import javax.swing.*;
import java.awt.*;


public class WhiteBoard extends JPanel {




    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(majorFrame.image,0,0,this);

        }


    }
