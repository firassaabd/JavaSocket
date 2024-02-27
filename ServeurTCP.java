import java.io.*;
import java.net.*;

class ServeurTCP {
    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);//port de serveur 

        while (true) {
            Socket connectionSocket = serverSocket.accept();//établissement de cnx
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));//récepteur
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());//expéditeur 
            String clientSentence = inFromClient.readLine();//lire Data sous forme String 
            System.out.println("Received from client: " + clientSentence);//afficher
            String capitalizedSentence = clientSentence.toUpperCase() + '\n';//traduction
            outToClient.writeBytes(capitalizedSentence);//envoyer
        }
    }
}