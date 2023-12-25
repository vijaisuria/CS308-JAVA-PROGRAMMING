import java.io.*;

public class FileDemo {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Replace with your file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {    
            String charsRead = null;
            // Read data from the file into the buffer
            while ((charsRead = reader.readLine()) != null) {
                System.out.print(charsRead);
            }

            // Convert characters read to string and display
            // String content = new String(buffer, 0, totalCharsRead);
            // System.out.println("Content read from the file:");
            // System.out.println(content);

            // try (Writer writer = new FileWriter("output.txt")) {
            //     writer.write(buffer, 0, totalCharsRead);
            // }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}