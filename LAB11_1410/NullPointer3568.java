package LAB11_1410;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class NullPointer3568 {
    public static void main(String args[]){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        int []array = null;

        try {
            System.out.print("Enter the any index to access: ");
            int i = in.nextInt();
            System.out.println("Array Element array["+i+"]: "+ array[i]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Unchecked Runtime Exception: \n" + e);
        }
        catch(Exception e){
            System.out.println("Other Exceptions: \n" + e);
        }
    }
}
