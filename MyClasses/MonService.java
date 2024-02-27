package MyClasses;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MonService extends Remote {
    String echo(String message) throws RemoteException;
}
