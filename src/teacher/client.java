import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client {

    Socket serverSocket;
    DataOutputStream dataOutputStream;

    public void send(String mesaj) {

        try {
            serverSocket = new Socket("localhost", 9001);
            dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
            dataOutputStream.writeUTF(mesaj);
            serverSocket.close();
        } catch (IOException ex) {
            chatBox.jtaMsgs.append("There is no participiants yet!\n ");
        }

    }
}







