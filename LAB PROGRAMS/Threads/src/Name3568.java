import java.time.LocalDate;
import java.time.LocalTime;
class Name implements Runnable{
    public void run(){
        System.out.println("My name is Vijai Suria M, using Runnable interface");
    }
}
class Names extends Thread {
    public void run(){
        System.out.println("My name is Vijai Suria M, using Thread class");
    }
}
public class Name3568 {
    public static void main(String[] args){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        Name obj = new Name();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(() -> {System.out.println("My name is Vijai Suria M, using Lambda function");});
        Thread t3 = new Names();
        t1.start();
        t2.start();
        t3.start();
    }
}

