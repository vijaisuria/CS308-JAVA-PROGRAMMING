class Demo {
    public Demo() {
        System.out.println("Constructor of Demo");
    }
    
    static {
        System.out.println("Static of Demo");
    }
    
    {
        System.out.println("Instance of Demo");
    }
}

public class Class {
    static {
        System.out.println("Static of Class");
    }
    
    {
        System.out.println("Instance of Class");
    }

    private Class() {
        System.out.println("Constructor of Class");
    }   
    public static void main(String args[]){
        System.out.println("Main Method");
        Demo d = new Demo();
        Class c = new Class();
    }
}

