import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class TCPSortServer3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        try {
            ServerSocket serverSocket = new ServerSocket(9999); // Port to listen on
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept(); // Accept incoming connection
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine = in.readLine();
            String[] numbersArray = inputLine.split(" ");
            int[] intArray = Arrays.stream(numbersArray).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(intArray);

            String sortedNumbers = Arrays.toString(intArray);
            out.println(sortedNumbers);

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
