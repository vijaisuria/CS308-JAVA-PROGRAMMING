import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {

        try (BufferedInputStream in = new BufferedInputStream(new URL("https://vijaisuria.github.io").openStream());
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("index.html"))) {
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try{    
            URL url=new URL("https://vijaisuria.github.io");    
            HttpURLConnection huc=(HttpURLConnection)url.openConnection();  
            huc.getResponseCode();
            for(int i=1;i<=1;i++){  
                System.out.println(huc.getResponseCode());  
            }  
            huc.disconnect();   
        }
        catch(Exception e){System.out.println(e);}      
    }
}
