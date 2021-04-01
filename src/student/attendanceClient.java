import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class attendanceClient {
    Socket serverSide;
    DataOutputStream dos;
    public void sendAttendance (String name){
        try{
            serverSide=new Socket("localhost", 1923);
            dos=new DataOutputStream(serverSide.getOutputStream());
            dos.writeUTF(name);

            serverSide.close();

        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
