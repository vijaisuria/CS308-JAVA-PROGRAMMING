import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Verbalize3568 {
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion"};
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = scanner.nextInt();

        if (number < 1 || number > 9999) {
            System.out.println("Number out of range.");
        } else {
            String verbalized = verbalizeNumber(number);
            System.out.println(verbalized);
        }
        scanner.close();
    }

    private static String verbalizeNumber(int number) {
        if (number == 0) {
            return "Zero";
        }
        String verbalized = "";
        int thousandsIndex = 0;

        while (number > 0) {
            if (number % 1000 != 0) {
                verbalized = verbalizeChunk(number % 1000) + thousands[thousandsIndex] + " " + verbalized;
            }
            number /= 1000;
            thousandsIndex++;
        }
        return verbalized.trim();
    }

    private static String verbalizeChunk(int number) {
        if (number == 0) {
            return "";
        }
        if (number < 10) {
            return units[number];
        } else if (number < 20) {
            return teens[number - 10];
        } else if (number < 100) {
            return tens[number / 10] + " " + units[number % 10];
        } else {
            return units[number / 100] + " Hundred " + verbalizeChunk(number % 100);
        }
    }
}
