class MyException extends Exception {
    MyException(String s) {
        super(s);
    }
}

public class Main {
    static void m1() throws MyException {
        throw new MyException(null);
    }

    public static void main(String[] args) {
        try {
            m1();
        } catch (MyException e) {
            System.out.println(e + e.getMessage());
        } finally {
            System.out.println("Finally block");
        }
        System.out.println("Outside block - main()");
    }
}
