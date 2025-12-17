import java.net.*;
import java.io.*;


public class PeerServer extends Thread {
int port;


PeerServer(int port) {
this.port = port;
}


public void run() {
try (ServerSocket serverSocket = new ServerSocket(port)) {
System.out.println("Server started on port " + port);


while (true) {
Socket socket = serverSocket.accept();
new FileSender(socket).start();
}
} catch (Exception e) {
e.printStackTrace();
}
}
}