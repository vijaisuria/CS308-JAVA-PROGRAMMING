import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.*;

public class BufferStream {
    public static void main(String[] args) throws IOException {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("input1.txt"));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output1.txt"));
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (Exception e) {
            System.out.println("\nFile Exception at \n" + e.getMessage());
        }
    }
}
