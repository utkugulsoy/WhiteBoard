import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server extends Thread {
    String taken;


    public String receive() {
        while (true) {
            ServerSocket serverSocket;
            Socket clientSocket;
            DataInputStream dataInputStream;
            String mesaj = null;
            try {
                serverSocket = new ServerSocket(9000);
                clientSocket = serverSocket.accept();
                dataInputStream = new DataInputStream(clientSocket.getInputStream());
                mesaj = dataInputStream.readUTF();

                serverSocket.close();
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return mesaj;
        }
    }



    @Override
    public void run() {
        while(true) {
            server srv;
            srv = new server();
            taken = srv.receive();
            chatBox.jtaMsgs.append(taken+"\n");
        }
    }
}
