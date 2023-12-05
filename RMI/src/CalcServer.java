import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalcServer {
    public static void main(String[] args){
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("Registry created");
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            Calculator c = new Calculator();
            Naming.bind("Calcservice", c);
            Naming.rebind("rmi://127.0.0.1/Calcservice", c);
            System.out.println("Service started......");
        }
        catch (RemoteException | MalformedURLException re) {
            System.out.println(re);
        } catch (AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
}
