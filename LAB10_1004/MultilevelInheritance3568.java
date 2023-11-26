import java.time.LocalDate;
import java.time.LocalTime;

class LivingBeing {
    String name;

    LivingBeing(String name) {
        this.name = name;
    }

    void Breath() {
        System.out.println(name + " is breathing...");
    }

    void Response() {
        System.out.println(name + " is responding to stimuli...");
    }

    public String toString() {
        return " Name: " + name;
    }
}

// First-level derived class
class Animal extends LivingBeing {
    int numberOfLegs;

    Animal(String name, int numberOfLegs) {
        super(name);
        this.numberOfLegs = numberOfLegs;
    }

    void Walk() {
        System.out.println(name + " is walking...");
    }

    int NoOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Number of Legs: " + numberOfLegs;
    }
}

// Second-level derived class
class Cat extends Animal {
    String breed;

    Cat(String name, int numberOfLegs, String breed) {
        super(name, numberOfLegs);
        this.breed = breed;
    }

    void Meow() {
        System.out.println(name + " is meowing...");
    }

    @Override
    public String toString() {

        return super.toString() + "\n Breed: " + breed;
    }
}

// Second-level derived class
class Dog extends Animal {
    String breed;

    Dog(String name, int numberOfLegs, String breed) {
        super(name, numberOfLegs);
        this.breed = breed;
    }

    void Bark() {
        System.out.println(name + " is barking...");
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n Breed: " + breed;
    }
}

public class MultilevelInheritance3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Cat cat = new Cat("Laks", 4, "Siamese");
        Dog dog = new Dog("Copper", 4, "Pomeranian");
        System.out.println(cat);
        cat.toString();
        cat.Breath();
        cat.Response();
        cat.Walk();
        System.out.println("Number of legs: " + cat.NoOfLegs());
        cat.Meow();

        System.out.println();
        System.out.println(dog);
        dog.toString();
        dog.Breath();
        dog.Response();
        dog.Walk();
        System.out.println("Number of legs: " + dog.NoOfLegs());
        dog.Bark();

    }
}
