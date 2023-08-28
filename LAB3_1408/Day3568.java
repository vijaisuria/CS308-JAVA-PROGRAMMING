import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Scanner;

public class Day3568 {
    static String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(days[dayOfWeek - 1].toString().toUpperCase());

        in.close();
    }
}
