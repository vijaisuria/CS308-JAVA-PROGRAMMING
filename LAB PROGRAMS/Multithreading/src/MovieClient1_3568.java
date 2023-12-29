import java.io.*;
import java.net.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class MovieClient1_3568 {
    private static final String SERVER_IP = "127.0.0.1"; // Change this to the server's IP address
    private static final int PORT = 8888;

    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        System.out.println("\n");
        try (Socket socket = new Socket(SERVER_IP, PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to the Movie Ticket Booking Server.");

            while (true) {
                System.out.println("Enter 'bookTicket' to book a ticket or 'exit' to quit:");
                String userInput = reader.readLine();

                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.println(userInput);

                String serverResponse = serverReader.readLine();
                System.out.println("Server Response: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}