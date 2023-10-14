package LAB11_1410;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.io.IOException;

public class FileNotFound3568 {
    public static void main(String args[]) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\2021503518\\Desktop\\input.txt");
            FileOutputStream out = new FileOutputStream("C:\\Users\\2021503518\\Desktop\\output.txt");
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
