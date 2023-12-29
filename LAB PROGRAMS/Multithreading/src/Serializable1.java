import java.io.*;
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    transient String name;
    private transient int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

public class Serializable1 {
    public static void main(String[] args) {
        // Serialization
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            Person person = new Person("Alice", 30);
            objectOut.writeObject(person);
            System.out.println("Serialized: " + person);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            Person deserializedPerson = (Person) objectIn.readObject();
            System.out.println("Deserialized: " + deserializedPerson + " " + deserializedPerson.name);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
