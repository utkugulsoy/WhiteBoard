import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class timeClient {
    Socket serverSocket;
    DataOutputStream dataOutputStream;

    public void sendTime(String time) {

        try {
            serverSocket = new Socket("localhost", 1881);
            dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
            dataOutputStream.writeUTF(time);
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}

