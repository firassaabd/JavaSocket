import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import MyClasses.*;

public class ServeurRMI {
    public static void main(String[] args) throws Exception {
        MonService service = new MonServiceImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("MonService", service);
        System.out.println("Serveur RMI prêt.");
    }
}