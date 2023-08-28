import java.time.*;
import java.util.Scanner;

public class Bug3568 {
    public static void main (String args[]) {
        System.out.println("Current Date: " + java.time.LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        String name;
        Scanner in=new Scanner(System.in);
        System.out.println("Hello. Please type your name: ");
        name = in.next();
        System.out.println("Hello "+name);
        System.out.println ("Have a, nice day!");
        in.close();
    } 
}
