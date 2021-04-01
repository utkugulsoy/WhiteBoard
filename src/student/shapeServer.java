import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;

public class shapeServer extends Thread {

    public static BufferedImage img = null;


    public static BufferedImage ReceiveShape() {

        while (true) {
            try {
                Socket clientSide;
                ServerSocket serverSocket = new ServerSocket(6066);

                clientSide = serverSocket.accept();
                img = ImageIO.read(ImageIO.createImageInputStream(clientSide.getInputStream()));
                File outputfile=new File("null.png");

                ImageIO.write(img,"png", outputfile);
                serverSocket.close();
                clientSide.close();


            } catch (IOException e) {
                //e.printStackTrace();
                break;
            }

        }
    return img;
    }




    @Override

    public void run() {


    while(true){
        shapeServer.ReceiveShape();


    }

    }
}
