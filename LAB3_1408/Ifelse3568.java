import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Ifelse3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N%2==1){
            System.out.println("Weird");
        }
        else if((N>=2 && N<=5) || (N>20)){
            System.out.println("Not Weird");
        }
        else{
            System.out.println("Weird");
        }
        in.close();
    }
}
