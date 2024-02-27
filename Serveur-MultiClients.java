import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        final int PORT = 12345; // Port d'écoute du serveur
        final int MAX_CLIENTS = 10; // Nombre maximal de clients à traiter en parallèle
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur TCP démarré sur le port " + PORT);

            while (true) {
                // Attendre une connexion entrante
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouveau client connecté : " + clientSocket);

                // Créer un thread pour gérer le client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();

                // Limiter le nombre de clients en parallèle
                if (Thread.activeCount() - 1 >= MAX_CLIENTS) {
                    System.out.println("Nombre maximal de clients atteint. Fermeture du serveur.");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                // Lire la chaîne envoyée par le client
                String inputLine = reader.readLine();
                System.out.println("Reçu du client : " + inputLine);

                // Inverser la chaîne de caractères
                StringBuilder reversedString = new StringBuilder(inputLine).reverse();

                // Simuler un traitement en attente
                Thread.sleep(2000);

                // Envoyer la chaîne inversée au client
                writer.println(reversedString.toString());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
