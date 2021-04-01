import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class majorFrame extends JFrame implements KeyListener, MouseListener, ActionListener {


    static ArrayList<shapeInfo> shapeStack = new ArrayList<>();
    public static String s;
    shapeClient shpclt;

    String participipants;


    BorderLayout bl;
    FlowLayout fl;
    BoxLayout boxl;

    JPanel northJP;
    JPanel eastJP;

    JPanel jpWhiteBoard;

    JLabel jlCounter;

    JLabel jlTimer;
    JCheckBox jcbxStopClass;

    protected static int id = 0;
    protected static int x, y, z, t;

    protected static boolean checkBoxController = false;
    boolean flag = false;
    protected static int counter = 0;
    protected static int minute = 39, sec = 59;
    menuBar myMenu;
    protected static Color myColor, c, eraser = Color.WHITE;

    public void center() {
        jpWhiteBoard = new WhiteBoard();
        jpWhiteBoard.setBackground(Color.WHITE);
        jpWhiteBoard.addMouseListener(this);
        add(jpWhiteBoard, BorderLayout.CENTER);
    }

    public void east() {
        eastJP = new JPanel();

        boxl = new BoxLayout(eastJP, BoxLayout.PAGE_AXIS);
        eastJP.setLayout(boxl);
        eastJP.setPreferredSize(new Dimension(250, 0));


        chatBox MyChatBox = new chatBox();
        eastJP.add(MyChatBox);

        add(eastJP, BorderLayout.EAST);

    }


    public majorFrame() {
        super("Fake Adobe Conncect");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        shpclt = new shapeClient();
        s = System.getProperty("user.dir");
        bl = new BorderLayout();
        setLayout(bl);
        center();


        northJP = new JPanel();
        fl = new FlowLayout();
        northJP.setLayout(fl);
        add(northJP, BorderLayout.NORTH);

        jlTimer = new JLabel();
        jlCounter = new JLabel();

        myMenu = new menuBar();

        northJP.add(myMenu);

        northJP.add(jlCounter);

        jlCounter.setText("Shapes were drawn");


        northJP.add(jlTimer);
        jcbxStopClass = new JCheckBox("Stop Class");
        northJP.add(jcbxStopClass);
        jcbxStopClass.addActionListener(this);


        jlTimer.setText("Remaining time:" + minute + ":" + sec);

        east();


        menuBar.line.addActionListener(this);

        menuBar.smallCircle.addActionListener(this);
        menuBar.mediumCircle.addActionListener(this);
        menuBar.largeCircle.addActionListener(this);

        menuBar.smallSquare.addActionListener(this);
        menuBar.mediumSquare.addActionListener(this);
        menuBar.largeSquare.addActionListener(this);
        menuBar.eraser.addActionListener(this);

        menuBar.finishClass.addActionListener(this);
        menuBar.colorPicker.addActionListener(this);
        menuBar.clearPage.addActionListener(this);
        menuBar.attendance.addActionListener(this);


        enabledController();
    }

    public void enabledController() {

        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!personInformation.check) {
                    setEnabled(false);


                } else {
                    setEnabled(true);
                    ((Timer) e.getSource()).stop();
                    timer();
                }
            }
        });
        t.start();


    }

    public void timer() {
        timeClient tclt = new timeClient();
        Timer myTimer = new Timer(1000, new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (checkBoxController == false) {
                    if (sec == 0) {
                        sec = 60;
                        minute--;
                    }
                    if (minute < 0) {
                        minute = 0;
                        sec = 0;
                        ((Timer) e.getSource()).stop();
                        timeFrame tf = new timeFrame();

                        tf.setVisible(true);

                    } else {
                        sec--;
                        jlTimer.setForeground(Color.RED);
                        jlTimer.setText("Remaining time:" + minute + ":" + sec);
                        tclt.sendTime(String.valueOf(minute) + ":" + String.valueOf(sec));
                    }
                }
            }
        });
        myTimer.start();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        shapeInfo p = new shapeInfo();
        if (id == 1) {
            if (!flag) {
                x = e.getX();
                y = e.getY();
                flag = true;
            } else {
                z = e.getX();
                t = e.getY();
                flag = false;
                p.x = majorFrame.x;
                p.y = majorFrame.y;
                p.z = majorFrame.z;
                p.t = majorFrame.t;
                p.shapeColor = c;
                p.shapeType = 1;
                shapeStack.add(p);

                repaint();
                counter++;
                jlCounter.setText(counter + " Shapes were drawn");

                captureComponent(jpWhiteBoard);
                shpclt.sendImg();
            }


        } else if (id == 2) {

            p.x = e.getX();
            p.y = e.getY();
            p.shapeColor = c;
            p.shapeType = 2;
            shapeStack.add(p);
            repaint();
            counter++;
            jlCounter.setText(counter + " Shapes were drawn");

            captureComponent(jpWhiteBoard);
            shpclt.sendImg();


        } else if (id == 3) {
            p.x = e.getX();
            p.y = e.getY();
            p.shapeColor = c;
            p.shapeType = 3;
            shapeStack.add(p);
            repaint();
            counter++;
            jlCounter.setText(counter + " Shapes were drawn");
            captureComponent(jpWhiteBoard);
            shpclt.sendImg();
        } else if (id == 4) {
            p.x = e.getX();
            p.y = e.getY();
            p.shapeColor = c;
            p.shapeType = 4;
            shapeStack.add(p);
            repaint();
            counter++;
            jlCounter.setText(counter + " Shapes were drawn");
            captureComponent(jpWhiteBoard);
            shpclt.sendImg();
        } else if (id == 5) {

            p.x = e.getX();
            p.y = e.getY();
            p.shapeColor = c;
            p.shapeType = 5;
            shapeStack.add(p);
            repaint();
            counter++;
            jlCounter.setText(counter + " Shapes were drawn");
            captureComponent(jpWhiteBoard);
            shpclt.sendImg();
        } else if (id == 6) {

            p.x = e.getX();
            p.y = e.getY();
            p.shapeColor = c;
            p.shapeType = 6;
            shapeStack.add(p);
            repaint();
            counter++;
            jlCounter.setText(counter + " Shapes were drawn");
            captureComponent(jpWhiteBoard);
            shpclt.sendImg();
        } else if (id == 7) {

            p.x = e.getX();
            p.y = e.getY();
            p.shapeColor = c;
            p.shapeType = 7;
            shapeStack.add(p);
            repaint();
            counter++;
            jlCounter.setText(counter + " Shapes were drawn");
            captureComponent(jpWhiteBoard);
            shpclt.sendImg();
        } else if (id == 8) {
            p.x = e.getX();
            p.y = e.getY();
            p.shapeColor = eraser;
            p.shapeType = 8;
            shapeStack.add(p);
            repaint();
            captureComponent(jpWhiteBoard);
            shpclt.sendImg();
        }

    }

    void captureComponent(Component component) {
        Rectangle rect = component.getBounds();

        try {
            String format = "png";
            String fileName = component.getName() + "." + format;
            BufferedImage captureImage =
                    new BufferedImage(rect.width, rect.height,
                            BufferedImage.TYPE_INT_ARGB);
            component.paint(captureImage.getGraphics());

            ImageIO.write(captureImage, format, new File(fileName));


        } catch (IOException ex) {
            //System.err.println(ex);
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuBar.line) {
            id = 1;
        } else if (e.getSource() == menuBar.smallSquare) {
            id = 2;
        } else if (e.getSource() == menuBar.mediumSquare) {
            id = 3;
        } else if (e.getSource() == menuBar.largeSquare) {
            id = 4;
        } else if (e.getSource() == menuBar.smallCircle) {
            id = 5;
        } else if (e.getSource() == menuBar.mediumCircle) {
            id = 6;
        } else if (e.getSource() == menuBar.largeCircle) {
            id = 7;
        } else if (e.getSource() == menuBar.eraser) {
            id = 8;
        }

        if (e.getSource() == menuBar.finishClass) {
            timeClient tclt = new timeClient();
            minute = 0;
            sec = 0;
            jlTimer.setText("Remaining time:" + minute + ":" + sec);
            tclt.sendTime(String.valueOf(minute) + ":" + String.valueOf(sec));
        }
        if (e.getSource() == menuBar.colorPicker) {

            c = JColorChooser.showDialog(this, "Choose Pen color", myColor);

        }
        if (e.getSource() == menuBar.clearPage) {
            shapeStack.clear();
            repaint();
            captureComponent(jpWhiteBoard);
            shpclt.sendImg();
        }
        if (e.getSource() == menuBar.attendance) {
            if (e.getSource() == menuBar.attendance) {

                try {

                    FileReader freader = new FileReader("Attendance.txt");
                    BufferedReader inputFile = new BufferedReader(freader);
                    participipants = inputFile.readLine();
                    JOptionPane.showMessageDialog(this, "PARTÄ°CÄ°PÄ°PANTS:\n" + participipants);
                    inputFile.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
        if (e.getSource() == jcbxStopClass) {
            if (checkBoxController == false) {
                checkBoxController = true;
            } else if (checkBoxController == true) {
                checkBoxController = false;

            }

        }


    }
}



