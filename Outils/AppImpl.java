package Outils;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AppImpl extends UnicastRemoteObject implements AppInterface {
    public AppImpl() throws RemoteException {
        super();
    }

    public String reverseString(String input) throws RemoteException {
        return new StringBuilder(input).reverse().toString();
    }
}
