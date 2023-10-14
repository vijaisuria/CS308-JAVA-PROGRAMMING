package LAB11_1410;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ArrayIndex3568 {
    public static void main(String args[]){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int n = in.nextInt();
        int []array = new int[n];

        try {
            System.out.print("Enter the any index to access: ");
            int i = in.nextInt();
            System.out.println("Array Element array["+i+"]: "+ array[i]);
            System.out.println("Below Exception");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Checked Runtime Exception: \n" + e);
        }
        catch(Exception e){
            System.out.println("Other Exceptions: \n" + e);
        }
        finally {
            System.out.println("Finally block");
        }

        System.out.println("Outside the try catch block");
    }
}
