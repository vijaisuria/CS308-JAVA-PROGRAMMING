import java.util.Scanner;
import java.util.concurrent.*;
import java.time.LocalTime;
import java.time.LocalDate;

class CallableInterface implements Callable<String> {
    public String call(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name: ");
        return in.nextLine();
    }
}
public class Callable3568 {
    public static void main(String[] args) throws Exception{
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");

        ExecutorService task = Executors.newSingleThreadScheduledExecutor();
        Future<String> name = task.submit(new CallableInterface());
        System.out.println("Name returned by Callable interface: " + name.get());
        task.shutdown();
    }
}
