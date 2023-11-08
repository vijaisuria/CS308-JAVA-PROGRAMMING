import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileThread3568 {
    private static Path filePath = Paths.get("C:\\Users\\vijai\\Documents\\ASSIGNMENTS\\JAVA-PROGRAMMING/Threads/src/demo.txt");
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    byte[] fileContent = Files.readAllBytes(filePath);
                    String content = new String(fileContent);
                    System.out.println("Thread t1: File Content -\n" + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    byte[] fileContent = Files.readAllBytes(filePath);
                    String content = new String(fileContent);
                    System.out.println("Thread t2: File Content -\n" + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
