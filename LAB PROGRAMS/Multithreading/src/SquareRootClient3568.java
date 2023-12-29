import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class SquareRootClient3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        try {
            Socket socket = new Socket("localhost", 9999); // Connect to server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter a number to find its square root: ");
            String number = userInput.readLine();
            out.println(number); // Send number to server

            String serverResponse = in.readLine(); // Receive square root from server
            System.out.println("Server response: " + serverResponse);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
