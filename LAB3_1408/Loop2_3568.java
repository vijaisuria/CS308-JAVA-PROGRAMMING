import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Loop2_3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int prev=a;
            for(int j=0;j<n;j++){
                int curr=prev+(int)(Math.pow(2,j)*b);
                System.out.print(curr+ " ");
                prev=curr;
            }
            System.out.println();
        }
        in.close();
    }
}
