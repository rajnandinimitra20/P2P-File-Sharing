import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;

class FileSender extends Thread {

    Socket socket;

    FileSender(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            DataInputStream dis =
                    new DataInputStream(socket.getInputStream());
            DataOutputStream dos =
                    new DataOutputStream(socket.getOutputStream());

            String fileName = dis.readUTF();
            File file = new File("shared/" + fileName);

            if (!file.exists()) {
                dos.writeLong(-1);
                socket.close();
                return;
            }

            dos.writeLong(file.length());

            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int read;

            while ((read = fis.read(buffer)) > 0) {
                dos.write(buffer, 0, read);
            }

            fis.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
