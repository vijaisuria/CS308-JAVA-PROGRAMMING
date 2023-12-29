import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class EmailValidator3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an email address: ");
        String email =sc.nextLine();

        // Regular expression pattern for email validation
        String emailPattern = "^[a-zA-Z0-9_+.-]+@[a-zA-Z0-9.-]+\\.(com|in|edu)$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(emailPattern);

        // Match the input email against the pattern
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("Email is valid");

            // Split the email address using "@" symbol
            String[] parts = email.split("@");

            // Extract and print the username (case-insensitive)
            String username = parts[0];
            System.out.println("Username: " + username.toLowerCase());

            // Extract and print the domain name (case-insensitive)
            String domain = parts[1];
            System.out.println("Domain: " + domain.toLowerCase());
        } else {
            System.out.println("Email is invalid");
        }
        sc.close();
    }
}
