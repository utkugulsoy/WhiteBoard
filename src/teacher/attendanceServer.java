import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class attendanceServer extends Thread {
    public static String takenName = null;

    public static String attendanceReceive() {
        while (true) {
            ServerSocket serverSocket;
            Socket clientSocket;
            DataInputStream dis;
            OutputStream os;

            try {
                serverSocket = new ServerSocket(1923);
                clientSocket = serverSocket.accept();
                dis = new DataInputStream(clientSocket.getInputStream());
                takenName = dis.readUTF();
                System.out.println(takenName);
                PrintWriter writer = new PrintWriter("Attendance.txt", StandardCharsets.UTF_8);
                writer.println(takenName);
                writer.close();

                serverSocket.close();
                clientSocket.close();


            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        }
        return takenName;
    }

    @Override
    public void run() {
        attendanceServer.attendanceReceive();
    }

}
