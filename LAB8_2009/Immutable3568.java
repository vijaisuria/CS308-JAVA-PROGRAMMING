import java.time.LocalDate;
import java.time.LocalTime;

public class Immutable3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        String originalString = "Hello, World!"; // Create an original string

        // Attempt to modify the string
        String modifiedString = originalString.concat(" Welcome to Java!");

        // Check if the original string is modified
        if (originalString == modifiedString) {
            System.out.println("Original string is the same as the modified string.");
        } else {
            System.out.println("Original string is different from the modified string.");
        }

        // Print the original and modified strings
        System.out.println("Original String: " + originalString);
        System.out.println("Modified String: " + modifiedString);
    }
}
