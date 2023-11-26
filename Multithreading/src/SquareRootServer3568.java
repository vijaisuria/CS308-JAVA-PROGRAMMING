import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class SquareRootServer3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        try {
            ServerSocket serverSocket = new ServerSocket(9999); // Port to listen on
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept(); // Accept incoming connection
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                double number = Double.parseDouble(inputLine);
                double squareRoot = Math.sqrt(number);
                out.println("Square root of " + number + " is: " + squareRoot);
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
