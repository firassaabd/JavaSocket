package Outils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FabImpl extends UnicastRemoteObject implements FabInterface {
    public FabImpl() throws RemoteException {
        super();
    }

    public AppInterface createApp() throws RemoteException {
        return new AppImpl();
    }
}
