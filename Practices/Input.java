import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Check if there's another line of input available
        while (in.hasNextLine()) {
            // Read the next line of input
            String line = in.nextLine();
            System.out.println("Input received: " + line);
        } 
        if (!in.hasNextLine()) {
            System.out.println("No input available.");
        }

        in.close();
    }
}
