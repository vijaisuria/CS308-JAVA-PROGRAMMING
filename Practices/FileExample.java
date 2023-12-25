import java.io.*;

public class FileExample {
    public static void main(String[] args) {

        try {
            BufferedReader in;
            BufferedOutputStream out;
            in = new BufferedReader(new FileReader("sample.txt"));
            String i;
            while ((i = in.readLine()) != null) {
                System.out.println(i);
            }
            i = null;
            out = new BufferedOutputStream(new FileOutputStream("sample.txt"));
            out.write("welcome".getBytes());
            while ((i = in.readLine()) != null) {
                System.out.println(i);
            }
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e);
        }

        // try (OutputStream outputStream = new FileOutputStream("output.txt");
        // OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,
        // "UTF-8");
        // BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {

        // String text = "Hello, BufferedWriter!";
        // bufferedWriter.write(text);

        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // System.out.printf("%3$2.3f", "Done", 1, 5D);

    }
}
