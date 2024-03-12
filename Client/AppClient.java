package Client;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Outils.AppInterface;
import Outils.FabInterface;

@SuppressWarnings("deprecation")
public class AppClient {
    public static void main(String[] args) {

        
        if(System.getSecurityManager() == null) System.setSecurityManager(new
        RMISecurityManager()); 


        if (args.length != 1) {
            System.out.println("Utilisation : java ReverseClient <chaine>");
            System.exit(0);
        }


        try {
            // Récupération de la fabrique d'objets depuis rmiregistry
            Registry registry = LocateRegistry.getRegistry("localhost");
            FabInterface fab = (FabInterface) registry.lookup("Fabrique");

            // Création d'un objet et inversion de la chaîne de caractères
            AppInterface app = fab.createApp();
            String result = app.reverseString(args[0]);
            System.out.println("Resultat de l'inversion : " + result);
        } catch (Exception e) {
            System.err.println("Erreur lors de l'execution du client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
