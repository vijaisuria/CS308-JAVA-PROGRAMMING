import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class UDPServer3568 {
    private static final int PORT = 8888;

    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Lathasri S A \nRegister Number: (2021503518) \n");
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");

            // Receiving messages from clients
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client [" + clientAddress + ":" + clientPort + "]: " + receivedMessage);

                // Sending received message back to the sender client
                sendData(serverSocket, clientAddress, clientPort, receivedMessage.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendData(DatagramSocket socket, InetAddress address, int port, byte[] data) throws IOException {
        DatagramPacket sendPacket = new DatagramPacket(data, data.length, address, port);
        socket.send(sendPacket);
    }
}
