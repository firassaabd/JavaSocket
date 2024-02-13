import java.io.*;
import java.net.*;
//test test

class UDPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //lire donnée d'apres user (taper au clavier)
        DatagramSocket clientSocket = new DatagramSocket(); //ouvrir socket client
        InetAddress IPAddress = InetAddress.getByName("localhost"); //seek @ip
        byte[] sendData = new byte[1024];//DATA out
        byte[] receiveData = new byte[1024];//DATA in
        String sentence = inFromUser.readLine();//lire tapage du client sous frome des lignes (String)
        sendData = sentence.getBytes(); //préparer les données à envoyer
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);//ajouter les données, data_size, @ip_serveur et numero du port 
        clientSocket.send(sendPacket);//envoyer packet
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);//preparer datagram packet
        clientSocket.receive(receivePacket);//recevoir une paquet
        String modifiedSentence = new String(receivePacket.getData());//extraire les données
        System.out.println("FROM SERVER:" + modifiedSentence);//afficher les donnée
        clientSocket.close();//fermer le socket
    }
}
//commentaires et codes par Firas Abdelmoumen ICE3