import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.time.Year;

public class Days3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the month(1-12): ");
        int month = in.nextInt();
        if(month<1 || month>12){
            System.out.println("Invalid month");
            System.exit(0);
        }
        System.out.print("Enter the year: ");
        int year = in.nextInt();
        if(year<=999 || year>9999){
            System.out.println("Invalid year");
            System.exit(0);
        }
        switch(month){
            case 1:
                System.out.println("The number of days in the month (January) is "+31);
                break;
            case 2:
                Year y = Year.of(year);
                if(y.isLeap())
                    System.out.println("The number of days in the month (Febrauary) is "+29);
                else
                System.out.println("The number of days in the month (Febrauary) is "+28);
                break;
            case 3:
                System.out.println("The number of days in the month (March) is "+31);
                break;
            case 4:
                System.out.println("The number of days in the month (April) is "+30);
                break;
            case 5:
                System.out.println("The number of days in the month (May) is "+31);
                break;
            case 6:
                System.out.println("The number of days in the month (June) is "+30);
                break;
            case 7:
                System.out.println("The number of days in the month (July) is "+31);
                break;
            case 8:
                System.out.println("The number of days in the month (August) is "+31);
                break;
            case 9:
                System.out.println("The number of days in the month (September) is "+30);
                break;
            case 10:
                System.out.println("The number of days in the month (October) is "+31);
                break;
            case 11:
                System.out.println("The number of days in the month (November) is "+30);
                break;
            case 12:
                System.out.println("The number of days in the month (December) is "+31);
                break;
            default:
                System.out.println("Invalid Month");
                break;
        }
        in.close();
    }
}
