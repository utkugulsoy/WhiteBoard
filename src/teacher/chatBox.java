import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class chatBox extends JPanel implements ActionListener, KeyListener {
    JTextField msgBox;
    static JTextArea jtaMsgs;
    JButton jbSend;
    JScrollPane scrollPane;
    JScrollBar scrollBar;
    client clt;




    chatBox()  {
        clt=new client();
        setLayout(null);
        setBackground(Color.decode("#E8E1E9"));
        msgBox= new JTextField();
        msgBox.setSize(250,25);
        msgBox.setLocation(0,635);
        msgBox.addKeyListener(this);

        jbSend=new JButton("SEND");
        jbSend.setBounds(0,657,250,20);
        jbSend.addActionListener(this);



        jtaMsgs =new JTextArea();


        jtaMsgs.setBackground(Color.decode("#C3F0F0"));
        jtaMsgs.setFont(new Font("Times New Roman", Font.ITALIC, 15));
        jtaMsgs.setForeground(Color.RED);
        jtaMsgs.setSize(200,250);

        jtaMsgs.setEditable(false);

        scrollPane=new JScrollPane(jtaMsgs);

        scrollBar=new JScrollBar();
        scrollBar.setSize(20,200);
        scrollPane.add(scrollBar);

        scrollPane.setSize(250,250);
        scrollPane.setLocation(0,380);

        add(msgBox);
        add(scrollPane);
        add(jbSend);







    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbSend){
            clt.send(personInformation.name+": "+msgBox.getText());
            jtaMsgs.append(personInformation.name+": "+msgBox.getText()+"\n");
            msgBox.setText("");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            clt.send(personInformation.name+": "+msgBox.getText());
            jtaMsgs.append(personInformation.name+": "+msgBox.getText()+"\n");
            msgBox.setText("");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }











}
