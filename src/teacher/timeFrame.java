import javax.swing.*;
import java.awt.*;

public class timeFrame extends JFrame {
    animationPanel myAp;

    public timeFrame(){
        super("Time Is Over!");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(500,500);
        setLayout(new BorderLayout());
        myAp=new animationPanel();
        myAp.setBackground(Color.WHITE);
        add(myAp,BorderLayout.CENTER);

    }
}
