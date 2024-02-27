import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import MyClasses.*;

public class ClientRMI {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        MonService service = (MonService) registry.lookup("MonService");
        String response = service.echo("Hello, RMI!");
        System.out.println("Réponse du serveur : " + response);
    }
}