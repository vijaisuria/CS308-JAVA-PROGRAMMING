import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new URL("https://vijaisuria.github.io").openConnection().getInputStream()));
                BufferedWriter out = new BufferedWriter(new FileWriter("index.html"))) {
            String i;
            while ((i = in.readLine()) != null) {
                out.write(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            URL url = new URL("https://vijaisuria.github.io");
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.getResponseCode();
            for (int i = 1; i <= 1; i++) {
                System.out.println(huc.getResponseCode());
            }
            huc.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
