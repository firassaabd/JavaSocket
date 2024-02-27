import java.io.*;
import java.net.*;
import java.util.Scanner;
import EX2-classe voiture.java;

public class SocketServeur {
 public static void main(String argv[]) {
 int port = 7899;
 Scanner keyb = new Scanner(System.in);
 // .............................................................
 System.out.print("Port d'écoute : ");
 try {
 port = keyb.nextInt();
 } catch (NumberFormatException e) {
 System.err.println("Le paramètre n'est pas un entier.");
 System.err.println("Usage : java ServeurUDP port-serveur");
 System.exit(-1);
 }
int c = 250;
 try {
 // .............................................................
 ServerSocket serverSocket = new ServerSocket(port);
 // ..........................................................

Socket socket = serverSocket.accept();
 // ..........................................................
 ObjectOutputStream output =
 new ObjectOutputStream(socket.getOutputStream());
 ObjectInputStream input =
 new ObjectInputStream(socket.getInputStream());
 // ..........................................................
 Voiture vv = input.readObject();
 System.out.println(" recu du serveur : " + vv.type + "--" + vv.model + "--" + vv.carburant);
 vv.setCarburant(c);
 // ..........................................................
 System.out.println(" ca vient Carburant : " + vv.carburant);
 // ..........................................................
 output.writeObject(vv);
 } catch (Exception e) {
 System.err.println("Erreur : " + e);
 }
 }
}