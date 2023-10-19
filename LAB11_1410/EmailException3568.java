import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

public class EmailException3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        try {
            String email;
            System.out.println("Enter the email: ");
            email = in.nextLine();
            validateEmail(email);
            System.out.println("Email is valid: " + email);
        } catch (InvalidEmailException e) {
            System.out.println("Invalid Email: " + e.getMessage());
        }
    }

    public static void validateEmail(String email) throws InvalidEmailException {
        if (!email.contains("@")) {
            throw new InvalidEmailException("Email is missing the '@' symbol.");
        }
    }
}
