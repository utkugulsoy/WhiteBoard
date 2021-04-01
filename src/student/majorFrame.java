import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class majorFrame extends JFrame implements  ActionListener {

	BorderLayout bl;
	FlowLayout fl;
	BoxLayout boxl;

	JPanel northJP;
	JPanel eastJP;

	JPanel jpWhiteBoard;
	JButton jbRaiseHand;

	 



	public static JLabel jlTimer;
	public static String path;
	public static BufferedImage image;

 public static ArrayList<shapeInfo> shapes=new ArrayList<>();



	protected static int minute = 40, sec = 10;

	public void center() {
		jpWhiteBoard = new WhiteBoard();
		jpWhiteBoard.setBackground(Color.WHITE);
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
		super("Paint");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		path=System.getProperty("user.dir");
		bl = new BorderLayout();
		setLayout(bl);
		center();

		northJP = new JPanel();
		fl = new FlowLayout();
		northJP.setLayout(fl);
		add(northJP, BorderLayout.NORTH);

		jlTimer = new JLabel();

		
		jbRaiseHand = new JButton();
		jbRaiseHand.setIcon(new ImageIcon(path+"\\hand.jpg"));
		northJP.add(jbRaiseHand);
		jbRaiseHand.addActionListener(this);
		



		northJP.add(jlTimer);
		jlTimer.setText("Remaining time:" + minute + ":" + sec);



		east();
		enabledController();
		updater();

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

				}
			}
		});
		t.start();


	}








	public void updater(){
		Timer updaterTimer= new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					image = ImageIO.read(new File(path+"\\null.png"));
					repaint();
				} catch (IOException ex) {
					//ex.printStackTrace();
				}
			}
		});
		updaterTimer.start();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		  if(e.getSource()==jbRaiseHand){
	            chatBox.clt.send(personInformation.name+": "+"Teacher, I have a question!");
	            chatBox.jtaMsgs.append(personInformation.name+": "+"Teacher, I have a question!"+"\n");


	        }
		
	}
}
