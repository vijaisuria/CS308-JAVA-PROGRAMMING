import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;


public class UDPClient3568 {
    private static final String SERVER_IP = "127.0.0.1"; // Change this to the server's IP address
    private static final int PORT = 8888;

    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Lathasri S A \nRegister Number: (2021503518) \n");

        try (DatagramSocket clientSocket = new DatagramSocket();
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            Thread serverListener = new Thread(() -> {
                try {
                    while (true) {
                        byte[] receiveData = new byte[1024];
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        clientSocket.receive(receivePacket);

                        String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                        System.out.println(receivedMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverListener.start();

            System.out.println("Connected to the chat server.");

            while (true) {
                String message = reader.readLine();
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PORT);
                clientSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
