package mka;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CountdownFrame implements ActionListener, MouseListener {
	private TimerClass tc;
	static JFrame countdown;
	Container cdc;
	JLabel time;
	JLabel text1, text2;
	JButton snoozeN, snoozeH;
	JButton resetCN, resetCH;
	String timestring;
	int count = 30;
	static Timer countdowntimer;
	JPanel countdownpanel;
	JLabel back;

	public CountdownFrame() {

		countdown = new JFrame("counter");
		time = new JLabel("");

		snoozeN = new JButton(new ImageIcon(getClass().getResource(
				"/images/buttonn.png")));
		snoozeH = new JButton(new ImageIcon(getClass().getResource(
				"/images/snooze.png")));
		
		resetCN = new JButton(new ImageIcon(getClass().getResource(
				"/images/resetCN.png")));
		resetCH = new JButton(new ImageIcon(getClass().getResource(
				"/images/resetCH.png")));
		
		back = new JLabel(new ImageIcon(getClass().getResource(
				"/images/countdown.png")));
		countdownpanel = new JPanel();

		countdowntimer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				count = count - 1;
				if (count < 0) {
					countdowntimer.stop();
					System.out.println("OVER");

					countdown.setVisible(false);

				}

				timestring = new Integer(count).toString();

				time.setText("" + timestring);
				time.setForeground(Color.black);
			}
		});

	}

	public void countercall()
	{

		countdowntimer.start();

	}

	public void initcountdown()
	{

		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		cdc = countdown.getContentPane();
		countdown.setSize(159, 182);
		countdown.setLocation(xSize - 180, ySize - 240);

		countdown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		countdown.setAlwaysOnTop(true);
		countdown.setUndecorated(true);
		// countdown.setShape(new RoundRectangle2D.Double(0, 0, 200, 320, 30,
		// 30));

		countdown.setVisible(true);
		countdown.setBackground(new Color(0, 0, 0, 0));
		countdown.setOpacity((float) 0.8);

		cdc.setBackground(new Color(0, 0, 0, 0));

		cdc.setLayout(null);
		countdownpanel.setBounds(10, 33, 134, 134);
		// countdownpanel.setLayout(null);

		cdc.add(countdownpanel);

		ImageIcon img = new ImageIcon(getClass().getResource("/images/mka.png"));
		countdown.setIconImage(img.getImage());

		time.setBounds(10, 0, 10, 40);
		time.setFont(new Font("Seoge UI", Font.PLAIN, 72));
		time.setForeground(Color.white);
		countdownpanel.add(time);

		snoozeN.setFocusPainted(false);
		snoozeN.setMargin(new Insets(0, 0, 0, 0));
		snoozeN.setContentAreaFilled(false);
		snoozeN.setBorderPainted(false);
		snoozeN.setOpaque(false);
		snoozeN.setCursor(new Cursor( Cursor.HAND_CURSOR));

		snoozeN.setBounds(4, 148, 76, 32);
		cdc.add(snoozeN);

		snoozeH.setFocusPainted(false);
		snoozeH.setMargin(new Insets(0, 0, 0, 0));
		snoozeH.setContentAreaFilled(false);
		snoozeH.setBorderPainted(false);
		snoozeH.setOpaque(false);
		snoozeH.setCursor(new Cursor( Cursor.HAND_CURSOR));

		snoozeH.setBounds(4, 148, 76, 32);
		snoozeH.setVisible(false);
		cdc.add(snoozeH);

		resetCN.setFocusPainted(false);
		resetCN.setMargin(new Insets(0, 0, 0, 0));
		resetCN.setContentAreaFilled(false);
		resetCN.setBorderPainted(false);
		resetCN.setOpaque(false);
		resetCN.setCursor(new Cursor( Cursor.HAND_CURSOR));

		resetCN.setBounds(80, 148, 74, 32);
		cdc.add(resetCN);

		resetCH.setFocusPainted(false);
		resetCH.setMargin(new Insets(0, 0, 0, 0));
		resetCH.setContentAreaFilled(false);
		resetCH.setBorderPainted(false);
		resetCH.setOpaque(false);
		resetCH.setCursor(new Cursor( Cursor.HAND_CURSOR));

		resetCH.setBounds(80, 148, 74, 32);
		resetCH.setVisible(false);
		cdc.add(resetCH);

		
		
		
		countdownpanel.setOpaque(false);

		cdc.add(back);
		back.setBounds(0, 0, 159, 185);

		snoozeN.addActionListener(this);
		snoozeN.addMouseListener(this);

		snoozeH.addActionListener(this);
		snoozeH.addMouseListener(this);
		
		resetCN.addActionListener(this);
		resetCN.addMouseListener(this);

		resetCH.addActionListener(this);
		resetCH.addMouseListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource() == snoozeH)
		{
			System.out.println("IN SNOOZE");
			snoozeN.setVisible(false);
			countdown.setVisible(false);
			
			TimerClass.snooze();
		}
		if (ae.getSource() == resetCH)
		{
			TimerClass.clk=0;
			//TimerClass.clk=TimerClass.clk-(55*60);
			resetCN.setVisible(false);
			countdown.setVisible(false);
			
			//TimerClass.snooze();
		}

	}

	@Override
	public void mouseClicked(MouseEvent a) {

	}

	@Override
	public void mouseEntered(MouseEvent a) {
		if (a.getSource() == snoozeN) {
			snoozeN.setVisible(false);
			snoozeH.setVisible(true);
		}
		if (a.getSource() == resetCN) {
			resetCN.setVisible(false);
			resetCH.setVisible(true);
		}

	}

	@Override
	public void mouseExited(MouseEvent a) {

		if (a.getSource() == snoozeH) {
			snoozeH.setVisible(false);
			snoozeN.setVisible(true);
		}
		if (a.getSource() == resetCH) {
			resetCH.setVisible(false);
			resetCN.setVisible(true);
		}


	}

	@Override
	public void mousePressed(MouseEvent a) {

	}

	@Override
	public void mouseReleased(MouseEvent a) {

	}

}
