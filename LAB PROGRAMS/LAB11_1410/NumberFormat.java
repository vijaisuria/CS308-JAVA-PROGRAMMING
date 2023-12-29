import java.time.LocalDate;
import java.time.LocalTime;

public class NumberFormat {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        try {
            String str = "abc123"; // This is not a valid number
            int number = Integer.parseInt(str);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
