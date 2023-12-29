import java.io.*;
import java.net.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieServer_JDBC3568 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/vijai-java";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
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
        private void insertBookingIntoDB() {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                int clientPort = clientSocket.getPort();
                String insertQuery = "INSERT INTO bookings (client_id, ticket_count, booking_time) VALUES (?, ?, NOW())";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setInt(1, clientPort); // Replace with the actual client ID
                preparedStatement.setInt(2, 1); // Assuming booking one ticket per request

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Booking inserted into the database.");
                } else {
                    System.out.println("Failed to insert booking.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        private void bookTicket(PrintWriter writer) {
            synchronized (lock) {
                if (availableTickets > 0) {
                    availableTickets--;
                    writer.println("Ticket booked successfully. Remaining tickets: " + availableTickets);
                    insertBookingIntoDB();
                } else {
                    writer.println("Sorry, tickets are sold out.");
                }
            }
        }
    }
}

