package LAB11_1410;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Arithmetic3568 {
    public static void main(String args[]){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Enter the any number to divide the number 25: ");
            int i = in.nextInt();
            System.out.println(" 25 / "+i+" = "+ (25/i));
        }
        catch(ArithmeticException e){
            System.out.println("Unchecked Runtime Exception: \n" + e);
        }
        catch(Exception e){
            System.out.println("Other Exceptions: \n" + e);
        }

    }
}
