import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class timeServer extends Thread {
    String takenTime;
    timeFrame tf;

    public String timeReceive() {
        while (true) {
            ServerSocket serverSocket;
            Socket clientSocket;
            DataInputStream dataInputStream;
            String mesaj = null;
            try {
                serverSocket = new ServerSocket(1881);
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
            timeServer tsrv;
            tsrv = new timeServer();
            takenTime= tsrv.timeReceive();
            majorFrame.jlTimer.setForeground(Color.RED);
            majorFrame.jlTimer.setText("Remaining time: "+takenTime);
            if(takenTime.equals("0:0")){
                tf=new timeFrame();
                tf.setVisible(true);
            }

        }
    }
}
