import java.io.*;
import java.net.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class TCPClient3568 {
    private static final String SERVER_IP = "127.0.0.1"; // Change this to the server's IP address
    private static final int PORT = 8888;

    public static void main(String[] args) {
        System.out.println("NAME: Vijai Suria.M \nReg No:2021503568");
        System.out.println("Date:" + LocalDate.now());
        System.out.println("Time:" + LocalTime.now());
        System.out.println("\n");
        try (Socket socket = new Socket(SERVER_IP, PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to the chat server.");

            Thread serverListener = new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = serverReader.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverListener.start();

            String name = serverReader.readLine();
            System.out.println(name);

            while (true) {
                String message = reader.readLine();
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
