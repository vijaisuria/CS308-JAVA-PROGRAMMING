import java.net.MalformedURLException;
import java.rmi.*;

public class CalcClient {
    public static void main(String[] args){
        try{
            Calc obj = (Calc) Naming.lookup("rmi://127.0.0.1/Calcservice");
            System.out.println(obj.add(2,3));
        }
        catch (MalformedURLException murle) {
            System.out.println(
                    "MalformedURLException");
            System.out.println(murle);
        }
        catch (RemoteException re) {
            System.out.println(
                    "RemoteException");
            System.out.println(re);
        }
        catch (NotBoundException nbe) {
            System.out.println(
                    "NotBoundException");
            System.out.println(nbe);
        }
        catch (java.lang.ArithmeticException ae) {
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);
        }
    }
}
