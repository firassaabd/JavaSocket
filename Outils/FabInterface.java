package Outils;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FabInterface extends Remote {
    AppInterface createApp() throws RemoteException;
}
