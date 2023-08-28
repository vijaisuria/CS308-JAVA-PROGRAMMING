import java.time.LocalTime;
import java.util.Scanner;

public class FinalVelocity3568 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Current Date: " + java.time.LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        System.out.print("Enter the Starting Speed u=");
        double u = in.nextDouble();
        System.out.print("Enter the Acceleration a=");
        double a = in.nextDouble();
        System.out.print("Enter the Time t=");
        double t = in.nextDouble();
        while(t<0){
            System.out.print("(Invalid Time Value, Enter the Time t=");
            t = in.nextDouble();
        }
        double v = u + a*t;
        System.out.println("Value of Velocity v=" + v);
        in.close();
    }
}
