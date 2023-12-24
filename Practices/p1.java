interface A {
    public static void staticMethod() {
        System.out.println("Static method in A");
    }
}

class ClassB implements A {

}

public class p1 {
    public static void main(String[] args) {
        A.staticMethod(); // Accessing via A
        ClassB.staticMethod();

        ClassB objB = new ClassB();
        objB.staticMethod(); // This is invalid - static methods cannot be accessed via instances
    }
}
