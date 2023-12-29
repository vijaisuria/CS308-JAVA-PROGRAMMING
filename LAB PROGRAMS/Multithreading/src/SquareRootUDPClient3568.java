import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class SquareRootUDPClient3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverIP = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter a number to find its square root: ");
            String number = userInput.readLine();
            sendData = number.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, 9999);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + serverResponse);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
