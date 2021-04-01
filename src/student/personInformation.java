import java.awt.event.*;

import javax.swing.*;

public class personInformation extends JFrame implements MouseListener, KeyListener {

    protected static JLabel JlName;
    protected static JTextField teacherName;
    protected static JButton jbSubmit;
    protected static String name=null;
    protected static boolean check=false;
    attendanceClient atclt;




    public personInformation() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250,250);
        setLayout(null);
        atclt=new attendanceClient();
        JlName = new JLabel();
        JlName.setBounds(10, 20, 200, 50);
        JlName.setText("Please Enter Your Name");

        teacherName = new JTextField();
        teacherName.setBounds(10, 70, 200, 25);
        teacherName.addMouseListener(this);


        jbSubmit=new JButton("Save");
        jbSubmit.setBounds(70,150,80, 40);

        add(JlName);
        add(teacherName);
        add(jbSubmit);

        jbSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==jbSubmit){
                    name= teacherName.getText();
                    if(name.equals("") || name.equals("Please enter name!")){
                        teacherName.setText("Please enter name!");
                        setVisible(true);
                        check=false;

                    }
                    else{
                        setVisible(false);
                        check=true;
                        atclt.sendAttendance(name);
                    }




                }

            }
        } );
        teacherName.addKeyListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== teacherName){
            teacherName.setText("");
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
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            name= teacherName.getText();
            if(name.equals("") || name.equals("Please enter name!")){
                teacherName.setText("Please enter name!");
                setVisible(true);
                check=false;

            }
            else{
                setVisible(false);
                check=true;
                atclt.sendAttendance(name);
            }

        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}