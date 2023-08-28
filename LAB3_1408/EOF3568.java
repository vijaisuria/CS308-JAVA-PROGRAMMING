import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class EOF3568 {
    public static void main(String[] args){
    System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner scan = new Scanner(System.in);
        int count=0;
        while(scan.hasNext())
        {
            String s = scan.nextLine();
            count++;
            System.out.println(count+" "+s);
        }
        scan.close();
}
}
