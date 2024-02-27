import java.io.*;
import java.net.*;
import java.util.Scanner;
import tp12Voiture.java;

class SocketClient {
 public static void main(String argv[]) {
 int port = 0;
 String host = "";
 Scanner keyb = new Scanner(System.in);
 // .............................................................
 System.out.print("Nom du serveur : ");
 host = keyb.next();
 System.out.print("Port du serveur : ");

Voiture v = new Voiture("Mercedes Benz","S200")

 try {
 port = keyb.nextInt();
 } catch (NumberFormatException e) {
 System.err.println("Le second paramètre n'est pas un entier.");
 System.exit(-1);
 }
 // .............................................................
 try {
 // .............................................................
 InetAddress adr = InetAddress.getByName(host);
 // .............................................................
 Socket socket = new Socket("172.168.89.1", port);
 // .............................................................
 ObjectOutputStream output =
 new ObjectOutputStream(socket.getOutputStream());
 ObjectInputStream input =
 new ObjectInputStream(socket.getInputStream());
 // .............................................................
 output.writeObject(v);
 // .............................................................
 String voiture_apres = input.readObject();
 System.out.println(" recu du serveur : " + voiture_apres.type + "--" + voiture_apres.model + "--" + voiture_apres.carburant);
 } catch (Exception e) {
 System.err.println("Erreur : " + e);
 }
 }
}