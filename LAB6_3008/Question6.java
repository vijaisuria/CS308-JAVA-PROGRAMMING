import java.time.LocalDate;
import java.time.LocalTime;

final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Question6 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Person person = new Person("John", 30);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // Attempting to modify the state of the person object (which is not allowed)
        // Uncommenting the following lines will result in a compilation error.
        // person.setName("Alice");
        // person.setAge(25);
    }
}
