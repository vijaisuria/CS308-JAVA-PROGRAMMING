import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Toss3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int res = random.nextInt(2);
        System.out.print("Enter your choice (h/t) or (H/T): ");
        char ch=in.next().charAt(0);
        if(ch=='h' || ch=='H'){
            if(res==1)
                System.out.println("Won the toss!");
            else
                System.out.println("Loss the toss!");
        }
        else{
            if(res==0)
                System.out.println("Won the toss!");
            else
                System.out.println("Loss the toss!");
        }
        System.out.println(res);
        in.close();
    }
}
