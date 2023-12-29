import java.time.LocalDate;
import java.time.LocalTime;

class LivingBeing {
    String name;

    LivingBeing(String name) {
        this.name = name;
    }

    protected void breath() {
        System.out.println("I am breating........");
    }

    protected void response() {
        System.out.println(
                "Hi, My response: My name is " + name + "I am a Living being. \n Thank youu!! \n Hava a Nice day :)");
    }

    public String toString() {
        return "My name is " + name;
    }
}

class Animal extends LivingBeing {
    int legs;

    Animal(int legs, String name) {
        super(name);
        this.legs = legs;
    }

    void setlegs(int legs) {
        this.legs = legs;
    }

    void getlegs(int legs) {
        System.out.println("No. of legs: " + legs);
    }

    void walk() {
        System.out.println("I am walking......");
    }

    @Override
    public String toString() {
        return super.toString() + ". I am a animal with " + legs + "legs";
    }
}

public class SingleInheritance3568 {
    public static void main(String args[]) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        Animal obj = new Animal(10, "Copper");
        System.out.println(obj);
    }
}