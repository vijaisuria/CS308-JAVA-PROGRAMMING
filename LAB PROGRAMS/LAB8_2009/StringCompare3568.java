import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class StringCompare3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.println("Enter the second string: ");
        String str2 = scanner.nextLine();


        String[] parts1 = str1.split("\\.");
        String[] parts2 = str2.split("\\.");

        if (parts1.length != 3 || parts2.length != 3) {
            System.out.println("Invalid input format. Please use dd.mm.ss format.");
            return;
        }

        int day1 = Integer.parseInt(parts1[0]);
        int month1 = Integer.parseInt(parts1[1]);
        int second1 = Integer.parseInt(parts1[2]);

        int day2 = Integer.parseInt(parts2[0]);
        int month2 = Integer.parseInt(parts2[1]);
        int second2 = Integer.parseInt(parts2[2]);

        if (day1 > day2) {
            System.out.println(str1 + " is greater than " + str2 + " as " + day1 + " > " + day2);
        } else if (day1 < day2) {
            System.out.println(str2 + " is greater than " + str1 + " as " + day2 + " > " + day1);
        } else {
            if (month1 > month2) {
                System.out.println(str1 + " is greater than " + str2 + " as " + month1 + " > " + month2);
            } else if (month1 < month2) {
                System.out.println(str2 + " is greater than " + str1 + " as " + month2 + " > " + month1);
            } else {
                if (second1 > second2) {
                    System.out.println(str1 + " is greater than " + str2 + " as " + second1 + " > " + second2);
                } else if (second1 < second2) {
                    System.out.println(str2 + " is greater than " + str1 + " as " + second2 + " > " + second1);
                } else {
                    System.out.println(str1 + " is equal to " + str2);
                }
            }
        }

        scanner.close();
    }
}
