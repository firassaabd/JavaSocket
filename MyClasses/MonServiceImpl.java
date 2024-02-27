package MyClasses;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MonServiceImpl extends UnicastRemoteObject implements MonService {
    public MonServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String echo(String message) throws RemoteException {
        return "Echo : " + message;
    }
}
