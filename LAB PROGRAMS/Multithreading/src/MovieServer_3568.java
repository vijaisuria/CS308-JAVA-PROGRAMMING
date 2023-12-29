import java.io.*;
import java.net.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MovieServer_3568 {
    private static final int PORT = 8888;
    private static final int MAX_AVAILABLE_TICKETS = 100;
    private static int availableTickets = MAX_AVAILABLE_TICKETS;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        System.out.println("\n");
        ExecutorService executor = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                Runnable clientHandler = new ClientHandler(clientSocket);
                executor.execute(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    if (clientMessage.equalsIgnoreCase("bookTicket")) {
                        bookTicket(writer);
                    } else {
                        writer.println("Invalid command.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void bookTicket(PrintWriter writer) {
            synchronized (lock) {
                if (availableTickets > 0) {
                    availableTickets--;
                    writer.println("Ticket booked successfully. Remaining tickets: " + availableTickets);
                } else {
                    writer.println("Sorry, tickets are sold out.");
                }
            }
        }
    }
}
 
