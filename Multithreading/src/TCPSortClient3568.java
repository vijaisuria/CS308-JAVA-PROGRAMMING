import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.LocalTime;

public class TCPSortClient3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        try {
            Socket socket = new Socket("localhost", 9999); // Connect to server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter numbers separated by spaces to be sorted: ");
            String numbers = userInput.readLine();
            out.println(numbers); // Send numbers to server

            String sortedNumbers = in.readLine(); // Receive sorted numbers from server
            int[] sortedArray = Arrays.stream(sortedNumbers.substring(1, sortedNumbers.length() - 1).split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            System.out.print("Sorted array received from server: ");
            for (int num : sortedArray) {
                System.out.print(num + " ");
            }
            System.out.println();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
