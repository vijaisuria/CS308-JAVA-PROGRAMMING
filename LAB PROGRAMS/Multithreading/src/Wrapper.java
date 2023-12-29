import java.util.ArrayList;
import java.util.Iterator;

class Sample{
    protected int a=10;
    protected void m1(){
        System.out.println("Sample class");
    }
}

public class Wrapper extends Sample{
    public void m1(){
        System.out.println("Wrapper class");
    }
    public static void main(String[] args) {
        Wrapper o1 = new Wrapper();
        o1.m1();
        Sample o2 = new Sample();
        ((Sample) o2).m1();
        if(o1 instanceof Wrapper)
            System.out.println("Wrapper class obj");
        if(o1 instanceof Sample)
            System.out.println("Sample class obj");
        if(o2 instanceof Wrapper)
            System.out.println("Wrapper class obj");
        if(o2 instanceof Sample)
            System.out.println("Sample class obj");
        if(o1 instanceof Object)
            System.out.println("Object-o1 class obj");
        if(o2 instanceof Sample)
            System.out.println("Object-o2 class obj");
    }
}
