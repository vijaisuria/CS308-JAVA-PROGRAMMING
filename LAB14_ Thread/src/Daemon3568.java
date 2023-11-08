import java.time.LocalDate;
import java.time.LocalTime;

public class Daemon3568 extends Thread{
    public void run(){
        if(Thread.currentThread().isDaemon()){//checking for daemon thread
            System.out.println("\nI am a Daemon thread\nThread name: " + Thread.currentThread().getName());
        }
        else{
            System.out.println("I am a user-defined thread");
        }
    }
    public static void main(String[] args){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        Daemon3568 t1=new Daemon3568();//creating thread
        Daemon3568 t2=new Daemon3568();
        Daemon3568 t3=new Daemon3568();

        t1.setDaemon(true);//now t1 is daemon thread
        t1.setName("Daemon");

        t1.start();//starting threads
        t2.start();
        t3.start();
    }
}