import java.io.*;

class Person implements Serializable {
    public String name;
    public int age;
    public String address;
    public String email;
}

public class Serialize3568 {
    public static void main(String args[]) throws Exception {
        System.out.println("Current Date: " + java.time.LocalDate.now());
        System.out.println("Current Time: " + java.time.LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Person PL;
        PL = new Person();
        PL.name = "Java";
        PL.age = 19;
        PL.address = "Chennai, Tamil Nadu, India";
        PL.email = "vijaisuriam@gmail.com";
        // Serialization
        String Filename = "File.txt";
        FileOutputStream fo = new FileOutputStream(Filename);
        ObjectOutputStream os = new ObjectOutputStream(fo);
        os.writeObject(PL);
        // DeSerialization
        FileInputStream fi = new FileInputStream(Filename);
        ObjectInputStream is = new ObjectInputStream(fi);
        Person p = (Person) is.readObject();
        System.out.println(p.name + " is " + p.age + " old living in " + p.address
                + " and you can mail at" + p.email);
    }
}
