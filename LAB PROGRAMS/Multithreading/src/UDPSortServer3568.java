import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.LocalTime;

public class UDPSortServer3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        try {
            DatagramSocket serverSocket = new DatagramSocket(9999); // Port to listen on
            System.out.println("Server started. Waiting for a client...");

            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                ByteArrayInputStream byteStream = new ByteArrayInputStream(receivePacket.getData());
                ObjectInputStream objInput = new ObjectInputStream(byteStream);

                int[] receivedArray = (int[]) objInput.readObject();
                Arrays.sort(receivedArray);

                ByteArrayOutputStream byteStreamOut = new ByteArrayOutputStream();
                ObjectOutputStream objOutput = new ObjectOutputStream(byteStreamOut);
                objOutput.writeObject(receivedArray);
                sendData = byteStreamOut.toByteArray();

                InetAddress clientIP = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, clientPort);

                serverSocket.send(sendPacket);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
