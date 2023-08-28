import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class dataType3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {      
            long x=sc.nextLong();
            System.out.println(x+" can be fitted in:");
            if(x>=-128 && x<=127) System.out.println("* byte");
            if(x>= -32768 && x<=32767) System.out.println("* short");
            if(x>= -2147483648 && x<=2147483647) System.out.println("* int");
            if(x>= -9223372036854775808l && x<=9223372036854775807l) System.out.println("* long");   
        }
        sc.close();
    }
}
