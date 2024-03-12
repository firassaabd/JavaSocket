package Server;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Outils.FabImpl;

@SuppressWarnings("deprecation")
public class AppServer {
    public static void main(String[] args) {

        // Installation du gestionnaire de sécurité RMI
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            // Création de l'annuaire rmiregistry
            LocateRegistry.createRegistry(1099);
            
            // Création et enregistrement de la fabrique d'objets
            FabImpl fab = new FabImpl();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Fabrique", fab);
            
            System.out.println("Serveur pret !");
        } catch (Exception e) {
            System.err.println("Erreur lors du demarrage du serveur : " + e.getMessage());
            e.printStackTrace();       
        }
    }
}
