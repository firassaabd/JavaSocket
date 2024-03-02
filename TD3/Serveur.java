
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import back.Interface;

public class Serveur extends UnicastRemoteObject implements Interface {

    public Serveur() throws RemoteException {
        super();
    }

    public double addition(double a, double b) throws RemoteException {
        return a + b;
    }

    public double soustraction(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }

    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Division par zéro.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
        Interface service = new Serveur();
        Registry registry = LocateRegistry.createRegistry(19999);
        registry.rebind("MonService", service);
        System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur: " + e);
        }
    }
}
