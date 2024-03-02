import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import back.Interface;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 19999);
            Interface service = (Interface) registry.lookup("MonService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Choisissez une opération :");
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");
                System.out.print("Votre choix : ");
                int choix = scanner.nextInt();

                if (choix == 5) {
                    break;
                }

                System.out.print("Entrez le premier nombre : ");
                double a = scanner.nextDouble();
                System.out.print("Entrez le deuxième nombre : ");
                double b = scanner.nextDouble();

                double resultat;
                switch (choix) {
                    case 1:
                        resultat = service.addition(a, b);
                        break;
                    case 2:
                        resultat = service.soustraction(a, b);
                        break;
                    case 3:
                        resultat = service.multiplication(a, b);
                        break;
                    case 4:
                        resultat = service.division(a, b);
                        break;
                    default:
                        System.out.println("Choix invalide.");
                        continue;
                }

                System.out.println("Résultat : " + resultat);
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Erreur: " + e);
        }
    }
}
