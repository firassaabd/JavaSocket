import java.io.*;
import java.net.*;

class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876); //nouvelle socket assignée à numero de port du serveur
        byte[] receiveData = new byte[1024]; //echange de paquet de taille 1Ko (fenetre du couche transport)
        byte[] sendData = new byte[1024];
        
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); // preparer l'allocation du packet à reçu
            serverSocket.send(sendPacket);
            serverSocket.receive(receivePacket); //recevoir le paquet envoyé par le client (DATA)
            String sentence = new String(receivePacket.getData()); //recevoir données sous forme String
            InetAddress IPAddress = receivePacket.getAddress(); //recevoir l'@ ip de client a partir du paquet envoyé et le mettre en variable crée par net-tools (InetAddress) : IPAdress
            int port = receivePacket.getPort(); //recevoir le numero du port de client a partir du paquet envoyé
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();// envoyer le message reçue en majuscule
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);// preparer l'allocation du packet à envoyer
            serverSocket.send(sendPacket);// envoyer le paquet
        }
//commentaires et codes par Firas Abdelmoumen ICE3
   