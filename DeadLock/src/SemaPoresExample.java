import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.Semaphore;
public class SemaPoresExample {
    public static Semaphore share=new Semaphore(2);

    public static void main(String a[]){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");

        new Thread(()->ShareResource(),"User 1").start();
        new Thread(()->ShareResource(),"User 2").start();
        new Thread(()->ShareResource(),"User 3").start();
        new Thread(()->ShareResource(),"User 4").start();
        new Thread(()->ShareResource(),"User 5").start();
        new Thread(()->ShareResource(),"User 6").start();
        new Thread(()->ShareResource(),"User 7").start();
    }

    public static void ShareResource(){
        try {
            share.acquire();
            System.out.println(Thread.currentThread().getName() + " Trying to acquire resource");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " have acquired resource");
            Thread.sleep(1000);
            share.release();
            System.out.println(Thread.currentThread().getName() + " have released resource");
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        }
}
