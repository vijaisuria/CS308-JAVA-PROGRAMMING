import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.*;
import java.util.Scanner;

public class F2C3568 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        float f, c;
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.print("Name: Vijai Suria M \nRegister Number: (2021503568)");

        System.out.println("\n Enter your choice \n 1) Fahrenheit to Celsius \n 2) Celsius to Fahrenheit ");
        int choice = in.nextInt();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        switch (choice) {
            case 1:
                System.out.print("Temperature in Fahrenheit: ");
                f = in.nextFloat();
                c = (f - 32) * 5 / 9;
                System.out.println("Equivalent Temperature in Celsius: " + decimalFormat.format(c));
                decimalFormat.setRoundingMode(RoundingMode.DOWN);  
                break;
            case 2:
                System.out.print("Temperature in Celsius: ");
                c = in.nextFloat();
                f = (9 * c / 5) + 32;
                System.out.println("Equivalent Temperature in Fahrenheit: "+
                        decimalFormat.format(f));
                        decimalFormat.setRoundingMode(RoundingMode.DOWN);  
                break;
            default:
                System.out.println("\n Please, Enter the valid choice......");
        }
        in.close();
    }
}
