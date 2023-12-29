import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.LocalTime;

public class UDPSortClient3568 {
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

            System.out.print("Enter numbers separated by spaces to be sorted: ");
            String numbers = userInput.readLine();
            String[] numbersArray = numbers.split(" ");
            int[] intArray = Arrays.stream(numbersArray).mapToInt(Integer::parseInt).toArray();

            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objOutput = new ObjectOutputStream(byteStream);
            objOutput.writeObject(intArray);
            sendData = byteStream.toByteArray();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, 9999);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            ByteArrayInputStream byteStreamIn = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream objInput = new ObjectInputStream(byteStreamIn);

            int[] sortedArray = (int[]) objInput.readObject();
            System.out.print("Sorted array received from server: ");
            for (int num : sortedArray) {
                System.out.print(num + " ");
            }
            System.out.println();

            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
