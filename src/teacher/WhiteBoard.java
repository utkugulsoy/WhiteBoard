import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class WhiteBoard extends JPanel {




    @Override
    public void paint(Graphics g) {
        super.paint(g);


        for (int i = 0; i < majorFrame.shapeStack.size(); i++) {

            if (majorFrame.shapeStack.get(i).shapeType == 1) {
                g.setColor(majorFrame.shapeStack.get(i).shapeColor);
                g.drawLine(majorFrame.shapeStack.get(i).x, majorFrame.shapeStack.get(i).y,
                        majorFrame.shapeStack.get(i).z, majorFrame.shapeStack.get(i).t);

            } else if (majorFrame.shapeStack.get(i).shapeType == 2) {
                g.setColor(majorFrame.shapeStack.get(i).shapeColor);
                g.fillRect(majorFrame.shapeStack.get(i).x, majorFrame.shapeStack.get(i).y, 50, 50);
            }
            else if (majorFrame.shapeStack.get(i).shapeType == 3) {
                g.setColor(majorFrame.shapeStack.get(i).shapeColor);
                g.fillRect(majorFrame.shapeStack.get(i).x, majorFrame.shapeStack.get(i).y, 100, 100);
            }
            else if (majorFrame.shapeStack.get(i).shapeType == 4) {
                g.setColor(majorFrame.shapeStack.get(i).shapeColor);
                g.fillRect(majorFrame.shapeStack.get(i).x, majorFrame.shapeStack.get(i).y, 200, 200);
            }
            else if (majorFrame.shapeStack.get(i).shapeType == 5) {
                Graphics2D g2d;
                g2d = (Graphics2D) g;
                Ellipse2D.Double circle = new Ellipse2D.Double(majorFrame.shapeStack.get(i).x-25,
                        majorFrame.shapeStack.get(i).y-25, 50, 50);
                g2d.setColor(majorFrame.shapeStack.get(i).shapeColor);
                g2d.fill(circle);
            }
            else if (majorFrame.shapeStack.get(i).shapeType == 6) {
                Graphics2D g2d;
                g2d = (Graphics2D) g;
                Ellipse2D.Double circle = new Ellipse2D.Double(majorFrame.shapeStack.get(i).x-50,
                        majorFrame.shapeStack.get(i).y-50, 100, 100);
                g2d.setColor(majorFrame.shapeStack.get(i).shapeColor);
                g2d.fill(circle);
            }
            else if (majorFrame.shapeStack.get(i).shapeType == 7) {
                Graphics2D g2d;
                g2d = (Graphics2D) g;
                Ellipse2D.Double circle = new Ellipse2D.Double(majorFrame.shapeStack.get(i).x-100,
                        majorFrame.shapeStack.get(i).y-100
                        , 200, 200);
                g2d.setColor(majorFrame.shapeStack.get(i).shapeColor);
                g2d.fill(circle);
            }else if (majorFrame.shapeStack.get(i).shapeType == 8) {
                g.setColor(majorFrame.shapeStack.get(i).shapeColor);
                g.fillRect(majorFrame.shapeStack.get(i).x, majorFrame.shapeStack.get(i).y, 50, 50);
            }
        }


    }}

