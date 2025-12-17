import java.io.*;
import java.net.*;
import java.util.Scanner;


public class PeerClient extends Thread {
public void run() {
try {
Scanner sc = new Scanner(System.in);
System.out.print("Enter Peer IP: ");
String ip = sc.next();
System.out.print("Enter Peer Port: ");
int port = sc.nextInt();
System.out.print("Enter File Name: ");
String fileName = sc.next();


Socket socket = new Socket(ip, port);
DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
DataInputStream dis = new DataInputStream(socket.getInputStream());


dos.writeUTF(fileName);
long fileSize = dis.readLong();


if (fileSize == -1) {
    System.out.println("File not found!");
return;
}


FileOutputStream fos = new FileOutputStream("received/" + fileName);
byte[] buffer = new byte[4096];
int read;
while (fileSize > 0 && (read = dis.read(buffer)) != -1) {
fos.write(buffer, 0, read);
fileSize -= read;
}
fos.close();
socket.close();
System.out.println("File received successfully");
} catch (Exception e) {
e.printStackTrace();
}
}
}