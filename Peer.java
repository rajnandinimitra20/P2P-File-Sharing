public class Peer {
public static void main(String[] args) {
int port = 5000; // change for each peer
new PeerServer(port).start();
new PeerClient().start();
}
}