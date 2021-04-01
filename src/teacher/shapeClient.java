import java.awt.image.BufferedImage;
import java.net.*;
import java.io.*;

import javax.imageio.*;


public class shapeClient {

    BufferedImage bimg;
    public void sendImg() {
        {

            try {

                Socket client = new Socket("localhost",6066);


                bimg = ImageIO.read(new File(majorFrame.s + "\\null.png"));

                ImageIO.write(bimg, "png", client.getOutputStream());

                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}