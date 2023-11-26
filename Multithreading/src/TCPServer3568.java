import java.io.*;
import java.net.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class TCPServer3568 {
    private static final int PORT = 8888;
    private static final Set<Socket> clientSockets = new HashSet<>();
    private static final Map<Socket, String> clientNames = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Date:" + LocalDate.now());
        System.out.println("Time:" + LocalTime.now());
        System.out.println("NAME: Vijai Suria .M \nReg No:2021503568");
        System.out.println("\n");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                clientSockets.add(clientSocket);

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private PrintWriter writer;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);

                writer.println("Enter your name:");
                String name = reader.readLine();
                clientNames.put(clientSocket, name);

                broadcastMessage(name + " joined the chat");

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    broadcastMessage(name + ": " + clientMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientNames.remove(clientSocket);
                clientSockets.remove(clientSocket);
                broadcastMessage(clientNames.getOrDefault(clientSocket, "Anonymous") + " left the chat");
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcastMessage(String message) {
            for (Socket socket : clientSockets) {
                if (socket != clientSocket) {
                    try {
                        PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
                        socketWriter.println(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
