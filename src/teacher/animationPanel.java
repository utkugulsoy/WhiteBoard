import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class animationPanel extends JPanel {

    int x=0;
    int y=100;
    int a=400;
    int b=200;
    public void paint(Graphics gp)
    {
        super.paint(gp);
        Graphics2D g2d= (Graphics2D) gp;
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("BOLD", BOLD, 35));

        g2d.drawString("TIME IS", x, y);
        g2d.drawString("OVER", a, b);
        g2d.drawString("THANKS ", x, 300);
        try {
            Thread.sleep(200);
            x+=20;
            a-=20;

            if(x>getWidth())
            {

                x=0;
            }
            if(a<0)
            {

                a=500;
            }
            repaint();

        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }




    }
}
