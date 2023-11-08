import java.time.LocalDate;
import java.time.LocalTime;

class CarThread extends Thread{
    private void method(){
        try {
            System.out.println(5/0);
        }
        catch(ArithmeticException e){
            System.out.println("Caught Arithmetic Exception inside " + Thread.currentThread().getName() + " thread");
            e.printStackTrace();
        }
    }
    public void run(){
        System.out.println("\nI am a thread");
        method();
    }
}
public class Exception3568 {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        try {
            System.out.println(5/0);
        }
        catch (ArithmeticException e){
            System.out.println("caught Exception Inside the " + Thread.currentThread().getName() + " thread");
            e.printStackTrace();
        }
        Thread.sleep(1000);
        CarThread BMW = new CarThread();
        BMW.setName("BMW");
        BMW.start();
    }
}
