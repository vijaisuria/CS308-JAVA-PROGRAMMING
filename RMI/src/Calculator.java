import java.rmi.RemoteException;

public class Calculator extends java.rmi.server.UnicastRemoteObject implements Calc{

    protected Calculator() throws RemoteException {
        super();
    }

    public int add(int a, int b){
        return a+b;
    }
}
