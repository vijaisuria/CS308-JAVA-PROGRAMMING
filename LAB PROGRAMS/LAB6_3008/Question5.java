import java.time.LocalDate;
import java.time.LocalTime;

class Example {
    int instanceVar;

    static int staticVar;

    void instanceMethod() {
        System.out.println("This is an instance method.");
        System.out.println("Instance variable value: " + instanceVar);
        System.out.println("Static variable value: " + staticVar);
    }

    static void staticMethod() {
        System.out.println("This is a static method.");
        // Instance variables cannot be accessed directly in a static method.
        // System.out.println("Instance variable value: " + instanceVar); // This will cause an error.
        System.out.println("Static variable value: " + staticVar);
    }
}

public class Question5 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Example.staticVar = 100;
        Example.staticMethod();

        Example obj1 = new Example();
        obj1.instanceVar = 42;
        obj1.instanceMethod();

        Example obj2 = new Example();
        obj2.instanceVar = 24;
        obj2.instanceMethod();
    }
}

