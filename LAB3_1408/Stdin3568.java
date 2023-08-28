import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Stdin3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        in.close();
    }
}
