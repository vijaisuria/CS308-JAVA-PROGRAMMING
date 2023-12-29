import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Stdin2_3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        double d = in.nextDouble();
        in.nextLine();
        String s = in.nextLine();
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        in.close();
        in.close();
    }
}
