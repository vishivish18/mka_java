//this is the main class from where execution starts

package mka;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class MKA extends JFrame implements ActionListener,MouseListener

{
	
	public static ServerSocket s;

	public static int mkaversion = 2;

	public static int flag = 0;
	static int frameflag = 0;

	static int aflag = 0;
	static int aboutflag = 0;
	
	static int timer[] = {45,50,55};
	

	static Point mouseDownCompCoords;
	static JPanel cp;
	static JFrame mp;
	JLabel back, exercisebody, settingsbody, aboutbody,version;
	static JLabel markerE, markerS, markerA;
	JButton close;
	JButton timerup,timerdown,timerupfade,timerdownfade;
	JButton reportabug, attribution;

	
	static JLabel timervalue;
	
	
	//JButton closeH;

	// /test
	static JLabel test, time;

	static JButton mkalogo;
	static JButton exerciseS;
	static JButton exerciseH;
	static JButton exerciseU;

	static JButton settingsS;
	static JButton settingsH;
	static JButton settingsU;

	static JButton aboutS;
	static JButton aboutH;
	static JButton aboutU;

	JButton Eon1, Eon2, Eon3, Eoff1, Eoff2, Eoff3, feedback1, feedback2,survey1,survey2;
	JButton Son1, Son2, Soff1, Soff2;

	static JLabel resetB;
	static JLabel resetH;
	static JButton timeredit;
	
	
	JLabel sankalp, specta;
	static JPanel exerciseP;
	static JPanel settingsP;
	static JPanel aboutP;

	// //////////flags

	int E1 = 0;

	Container m;

	public void assign()
	{

		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Windows".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (Exception e)
		{
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

		// testing
		mp = new JFrame();

		cp = new JPanel();
		exerciseP = new JPanel();
		settingsP = new JPanel();
		aboutP = new JPanel();

		// back = new JLabel(new ImageIcon("images//back1.png"));
		// ImageIcon img = new
		// ImageIcon(getClass().getResource("/images/icon.png"));
		back = new JLabel(new ImageIcon(getClass().getResource(
				"/images/back.png")));

		exercisebody = new JLabel(new ImageIcon(getClass().getResource(
				"/images/exp.png")));
		settingsbody = new JLabel(new ImageIcon(getClass().getResource(
				"/images/settp.png")));
		aboutbody = new JLabel(new ImageIcon(getClass().getResource(
				"/images/aboutbody.png")));
		close = new JButton(new ImageIcon(getClass().getResource(
				"/images/x.png")));
		//closeH = new JButton(new ImageIcon(getClass().getResource(
			//	"/images/xh.png")));

		markerE = new JLabel(new ImageIcon(getClass().getResource(
				"/images/markerE.png")));
		markerS = new JLabel(new ImageIcon(getClass().getResource(
				"/images/markerS.png")));
		markerA = new JLabel(new ImageIcon(getClass().getResource(
				"/images/markerA.png")));

		mkalogo = new JButton(new ImageIcon(getClass().getResource(
				"/images/mkalogo.png")));

		exerciseS = new JButton(new ImageIcon(getClass().getResource(
				"/images/exerciseS.png")));
		exerciseU = new JButton(new ImageIcon(getClass().getResource(
				"/images/exerciseU.png")));
		exerciseH = new JButton(new ImageIcon(getClass().getResource(
				"/images/exerciseH.png")));

		settingsS = new JButton(new ImageIcon(getClass().getResource(
				"/images/settingsS.png")));
		settingsU = new JButton(new ImageIcon(getClass().getResource(
				"/images/settingsU.png")));
		settingsH = new JButton(new ImageIcon(getClass().getResource(
				"/images/settingsH.png")));

		aboutS = new JButton(new ImageIcon(getClass().getResource(
				"/images/aboutS.png")));
		aboutU = new JButton(new ImageIcon(getClass().getResource(
				"/images/aboutU.png")));
		aboutH = new JButton(new ImageIcon(getClass().getResource(
				"/images/aboutH.png")));

		Eon1 = new JButton(new ImageIcon(getClass().getResource(
				"/images/on.png")));
		Eon2 = new JButton(new ImageIcon(getClass().getResource(
				"/images/on.png")));
		Eon3 = new JButton(new ImageIcon(getClass().getResource(
				"/images/on.png")));
		Eoff1 = new JButton(new ImageIcon(getClass().getResource(
				"/images/off1.png")));
		Eoff2 = new JButton(new ImageIcon(getClass().getResource(
				"/images/off1.png")));
		Eoff3 = new JButton(new ImageIcon(getClass().getResource(
				"/images/off1.png")));

		Son1 = new JButton(new ImageIcon(getClass().getResource(
				"/images/ondisable.png")));
		Son2 = new JButton(new ImageIcon(getClass().getResource(
				"/images/on.png")));

		Soff1 = new JButton(new ImageIcon(getClass().getResource(
				"/images/ondisable.png")));
		Soff2 = new JButton(new ImageIcon(getClass().getResource(
				"/images/off1.png")));

		feedback1 = new JButton(new ImageIcon(getClass().getResource(
				"/images/feedbackN.png")));
		feedback2 = new JButton(new ImageIcon(getClass().getResource(
				"/images/feedbackH.png")));
		survey1= new JButton(new ImageIcon(getClass().getResource(
				"/images/surveyN.png")));
		survey2 = new JButton(new ImageIcon(getClass().getResource(
				"/images/surveyH.png")));
		
		
		
		timerup= new JButton(new ImageIcon(getClass().getResource(
				"/images/timerup.png")));
		
		timerdown= new JButton(new ImageIcon(getClass().getResource(
				"/images/timerdown.png")));
		
		timerupfade= new JButton(new ImageIcon(getClass().getResource(
				"/images/timerupfade.png")));
		
		timerdownfade= new JButton(new ImageIcon(getClass().getResource(
				"/images/timerdownfade.png")));
		
		
		
		resetB = new JLabel(new ImageIcon(getClass().getResource(
				"/images/resetBack.png")));
		
		resetH = new JLabel(new ImageIcon(getClass().getResource(
				"/images/resetHover.png")));
		
		timeredit=  new JButton(new ImageIcon(getClass().getResource(
				"/images/timereditN.png")));

		attribution=  new JButton(new ImageIcon(getClass().getResource(
				"/images/information.png")));

		reportabug=  new JButton(new ImageIcon(getClass().getResource(
				"/images/bug.png")));
		
		sankalp = new JLabel("");
		specta = new JLabel("");
		
		version = new JLabel("(Version : 1.0.2)");

		test = new JLabel("Exercise starts in : ");
		test.setVisible(false);
		
		timervalue = new JLabel("");

		time = new JLabel("");
		time.setVisible(false);

	}

	public void hidecp() {
		mp.setVisible(false);
	}

	public void showcp() {
		mp.setVisible(true);
	}

	public static void aboutcp() {
		mp.setVisible(true);
		settingsS.setVisible(false);
		exerciseS.setVisible(false);
		exerciseU.setVisible(true);
		aboutS.setVisible(true);
		aboutU.setVisible(false);

		exerciseP.setVisible(false);
		settingsP.setVisible(false);
		aboutP.setVisible(true);

	}

	public void initcontrolpanel()
	{
		// /flag = 1;
		UserSettings setting = new UserSettings();
	
		m = mp.getContentPane();
		mp.setSize(600, 500);
		mp.setLocation(320, 100);

		mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mp.setLayout(null);
		mp.setUndecorated(true);
		mp.setBackground(new Color(0, 0, 0, 0));
		//mp.setOpacity((float) 0.5);
		mp.setVisible(true);

		cp.setSize(600, 500);
		cp.setLocation(0, 0);
		cp.setBackground(new Color(0, 0, 0, 0));

		ImageIcon img = new ImageIcon(getClass().getResource("/images/mka.png"));

		// /cp.setOpacity(0.90f);
		cp.setVisible(true);
		mp.setIconImage(img.getImage());

		// testing

		mp.add(cp);

		// c.setBackground(Color.white);
		// c.setBackground(new Color(246,246,246));
		cp.setLayout(null);
		close.setBounds(500, 33, 24, 24);
		// close.setVisible(false);
		close.setFocusPainted(false);
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setOpaque(false);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// close.setVisible(false);
		close.setToolTipText("Close");

		cp.add(close);

	/*	closeH.setBounds(499, 35, 24, 24);
		closeH.setFocusPainted(false);
		closeH.setMargin(new Insets(0, 0, 0, 0));
		closeH.setContentAreaFilled(false);
		closeH.setBorderPainted(false);
		closeH.setOpaque(false);
		closeH.setVisible(false);
		closeH.setToolTipText("Close");

		cp.add(closeH);
*/
		// ////////////**********exercise tab
		// starts*****************/////////////////

		
		exerciseS.setBounds(35, 303, 167,130);
		cp.add(exerciseS);
		exerciseS.setFocusPainted(false);
		exerciseS.setMargin(new Insets(0, 0, 0, 0));
		exerciseS.setContentAreaFilled(false);
		exerciseS.setBorderPainted(false);
		// settingsS.setOpaque(false);
		exerciseS.setVisible(true);
		// settingsS.setToolTipText("settingsS");

		exerciseH.setBounds(87,334,68, 94);

		exerciseH.setFocusPainted(false);
		exerciseH.setMargin(new Insets(0, 0, 0, 0));
		exerciseH.setContentAreaFilled(false);
		exerciseH.setBorderPainted(false);
		exerciseH.setVisible(false);
		exerciseH.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cp.add(exerciseH);

		exerciseU.setBounds(92, 339, 58, 80);
		cp.add(exerciseU);
		exerciseU.setFocusPainted(false);
		exerciseU.setMargin(new Insets(0, 0, 0, 0));
		exerciseU.setContentAreaFilled(false);
		exerciseU.setBorderPainted(false);
		exerciseU.setOpaque(false);
		// settingsU.setVisible(false);
		
		// settingsS.setToolTipText("settingsS");
		
		

		
		
		
		
		
		
		
		
		
/*		
		
		exerciseS.setBounds(65, 333, 139, 96);
		// exerciseS.setFocusPainted(false);
		exerciseS.setMargin(new Insets(0, 0, 0, 0));
		exerciseS.setContentAreaFilled(false);
		exerciseS.setBorderPainted(false);
		//exerciseS.setOpaque(false);
		cp.add(exerciseS);

		// exerciseS.setVisible(false);
		// exerciseS.setToolTipText("exerciseS");

		exerciseH.setBounds(77, 333, 116, 97);
		// exerciseS.setFocusPainted(false);
		exerciseH.setMargin(new Insets(0, 0, 0, 0));
		exerciseH.setContentAreaFilled(false);
		exerciseH.setBorderPainted(false);
		//exerciseH.setOpaque(false);
		exerciseH.setVisible(false);
		exerciseH.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cp.add(exerciseH);
		
		

		exerciseU.setBounds(82, 338, 106, 83);
		exerciseU.setFocusPainted(false);
		exerciseU.setMargin(new Insets(0, 0, 0, 0));
		exerciseU.setContentAreaFilled(false);
		exerciseU.setBorderPainted(false);
		// exerciseU.setVisible(false);
		//exerciseU.setOpaque(false);
		 
		 */

		cp.add(exerciseU);
		// exerciseS.setToolTipText("exerciseS");

		exerciseP.setLayout(null);
		exerciseP.setBounds(50, 70, 450, 250);
		exerciseP.setOpaque(false);
		// exerciseP.setVisible(false);
		cp.add(exerciseP);

		Eon1.setBounds(348, 57, 73, 36);
		Eon1.setFocusPainted(false);
		Eon1.setMargin(new Insets(0, 0, 0, 0));
		Eon1.setContentAreaFilled(false);
		Eon1.setBorderPainted(false);
		Eon1.setOpaque(false);
		Eon1.setVisible(false);
		Eon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exerciseP.add(Eon1);

		Eoff1.setBounds(348, 57, 73, 36);
		Eoff1.setFocusPainted(false);
		Eoff1.setMargin(new Insets(0, 0, 0, 0));
		Eoff1.setContentAreaFilled(false);
		Eoff1.setBorderPainted(false);
		Eoff1.setOpaque(false);
		Eoff1.setVisible(false);
		Eoff1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exerciseP.add(Eoff1);

		if (setting.getSetting("eye")) {
			Eon1.setVisible(true);
			Eoff1.setVisible(false);
		} else {
			Eoff1.setVisible(true);
		}

		Eon2.setBounds(348, 117, 73, 36);
		Eon2.setFocusPainted(false);
		Eon2.setMargin(new Insets(0, 0, 0, 0));
		Eon2.setContentAreaFilled(false);
		Eon2.setBorderPainted(false);
		Eon2.setOpaque(false);
		Eon2.setVisible(false);
		Eon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exerciseP.add(Eon2);

		Eoff2.setBounds(348, 117, 73, 36);
		Eoff2.setFocusPainted(false);
		Eoff2.setMargin(new Insets(0, 0, 0, 0));
		Eoff2.setContentAreaFilled(false);
		Eoff2.setBorderPainted(false);
		Eoff2.setOpaque(false);
		Eoff2.setVisible(false);
		Eoff2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exerciseP.add(Eoff2);

		if (setting.getSetting("body")) {
			Eon2.setVisible(true);
			Eoff2.setVisible(false);
		} else {
			Eoff2.setVisible(true);
		}

		Eon3.setBounds(348, 177, 73, 36);
		Eon3.setFocusPainted(false);
		Eon3.setMargin(new Insets(0, 0, 0, 0));
		Eon3.setContentAreaFilled(false);
		Eon3.setBorderPainted(false);
		Eon3.setOpaque(false);
		Eon3.setVisible(false);
		Eon3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exerciseP.add(Eon3);

		Eoff3.setBounds(348, 177, 73, 36);
		Eoff3.setFocusPainted(false);
		Eoff3.setMargin(new Insets(0, 0, 0, 0));
		Eoff3.setContentAreaFilled(false);
		Eoff3.setBorderPainted(false);
		Eoff3.setOpaque(false);
		Eoff3.setVisible(false);
		Eoff3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exerciseP.add(Eoff3);

		if (setting.getSetting("water")) {
			Eon3.setVisible(true);
			Eoff3.setVisible(false);
		} else {
			Eoff3.setVisible(true);
		}

		exercisebody.setBounds(30, 40, 407, 181);
		exerciseP.add(exercisebody);

		// //////*************exercise tab
		// ends*****************///////////////////////////////

		// /////*****************settings tab
		// starts**********************///////////

		settingsP.setLayout(null);
		settingsP.setBounds(50, 70, 450, 250);

		settingsP.setOpaque(false);
		settingsP.setVisible(false);
		cp.add(settingsP);

		Son1.setBounds(348, 116, 73, 36);
		Son1.setFocusPainted(false);
		Son1.setMargin(new Insets(0, 0, 0, 0));
		Son1.setContentAreaFilled(false);
		Son1.setBorderPainted(false);
		Son1.setOpaque(false);
		Son1.setVisible(false);
		//Son1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsP.add(Son1);

		Soff1.setBounds(348, 116, 73, 36);
		Soff1.setFocusPainted(false);
		Soff1.setMargin(new Insets(0, 0, 0, 0));
		Soff1.setContentAreaFilled(false);
		Soff1.setBorderPainted(false);
		Soff1.setOpaque(false);
		Soff1.setVisible(false);
		Soff1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsP.add(Soff1);

		if (setting.getSetting("startup")) 
		{
			Son1.setVisible(true);
			Soff1.setVisible(false);
		}
		else
		{
			Soff1.setVisible(true);
		}

		Son2.setBounds(348, 177, 73, 36);
		Son2.setFocusPainted(false);
		Son2.setMargin(new Insets(0, 0, 0, 0));
		Son2.setContentAreaFilled(false);
		Son2.setBorderPainted(false);
		Son2.setOpaque(false);
		Son2.setVisible(false);
		Son2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsP.add(Son2);

		Soff2.setBounds(348, 177, 73, 36);
		Soff2.setFocusPainted(false);
		Soff2.setMargin(new Insets(0, 0, 0, 0));
		Soff2.setContentAreaFilled(false);
		Soff2.setBorderPainted(false);
		Soff2.setOpaque(false);
		Soff2.setVisible(false);
		Soff2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsP.add(Soff2);

		
		timerup.setBounds(341,62 ,21, 11);
		timerup.setFocusPainted(false);
		timerup.setMargin(new Insets(0, 0, 0, 0));
		timerup.setContentAreaFilled(false);
		timerup.setBorderPainted(false);
		timerup.setOpaque(false);
		timerup.setVisible(true);
		timerup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsP.add(timerup);
		
		timerupfade.setBounds(341,62 ,21, 11);
		timerupfade.setFocusPainted(false);
		timerupfade.setMargin(new Insets(0, 0, 0, 0));
		timerupfade.setContentAreaFilled(false);
		timerupfade.setBorderPainted(false);
		timerupfade.setOpaque(false);
		timerupfade.setVisible(false);
		timerupfade.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsP.add(timerupfade);
		
		timerdown.setBounds(341,73 ,21, 11);
		timerdown.setFocusPainted(false);
		timerdown.setMargin(new Insets(0, 0, 0, 0));
		timerdown.setContentAreaFilled(false);
		timerdown.setBorderPainted(false);
		timerdown.setOpaque(false);
		timerdown.setVisible(true);
		timerdown.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsP.add(timerdown);
		
		
		timerdownfade.setBounds(341,73 ,21, 11);
		timerdownfade.setFocusPainted(false);
		timerdownfade.setMargin(new Insets(0, 0, 0, 0));
		timerdownfade.setContentAreaFilled(false);
		timerdownfade.setBorderPainted(false);
		timerdownfade.setOpaque(false);
		timerdownfade.setVisible(false);
		timerdownfade.setCursor(new Cursor(Cursor.HAND_CURSOR));
		settingsP.add(timerdownfade);
		
		
		
		if (setting.getSetting("autoupdate")) {
			Son2.setVisible(true);
			Soff2.setVisible(false);
		} else {
			Soff2.setVisible(true);
		}

		settingsS.setBounds(200, 303, 167, 130);
		cp.add(settingsS);
		settingsS.setFocusPainted(false);
		settingsS.setMargin(new Insets(0, 0, 0, 0));
		settingsS.setContentAreaFilled(false);
		settingsS.setBorderPainted(false);
		// settingsS.setOpaque(false);
		settingsS.setVisible(false);
		// settingsS.setToolTipText("settingsS");

		settingsH.setBounds(250, 339, 65, 92);

		settingsH.setFocusPainted(false);
		settingsH.setMargin(new Insets(0, 0, 0, 0));
		settingsH.setContentAreaFilled(false);
		settingsH.setBorderPainted(false);
		settingsH.setVisible(false);
		settingsH.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cp.add(settingsH);

		settingsU.setBounds(255, 344, 55, 78);
		cp.add(settingsU);
		settingsU.setFocusPainted(false);
		settingsU.setMargin(new Insets(0, 0, 0, 0));
		settingsU.setContentAreaFilled(false);
		settingsU.setBorderPainted(false);
		settingsU.setOpaque(false);
		// settingsU.setVisible(false);
		// settingsS.setToolTipText("settingsS");
		
		
		

		timervalue.setBounds(367, 63, 50, 20);
		timervalue.setFont(new Font("Open Sans", 0, 12));
		timervalue.setForeground(Color.white);
		
		
		settingsP.add(timervalue);

		settingsbody.setBounds(38, 47, 392, 173);
		settingsP.add(settingsbody);

		// ///////****************settings tab
		// ends*****************************/////////////

		// ///**********************about tab starts
		// ******************************//////////////////

		aboutP.setLayout(null);
		aboutP.setBounds(85, 105, 450, 250);
		aboutP.setOpaque(false);
		// aboutP.setVisible(false);
		aboutP.setBackground(Color.white);
		
		version.setBounds(170, 8, 100, 30);
		version.setForeground(Color.DARK_GRAY);
		version.setVisible(false);
		
		aboutP.add(version);

		cp.add(aboutP);
		

		feedback1.setBounds(312, 160, 68, 18);
		feedback1.setFocusPainted(false);
		feedback1.setMargin(new Insets(0, 0, 0, 0));
		feedback1.setContentAreaFilled(false);
		feedback1.setBorderPainted(false);
		feedback1.setOpaque(false);
		feedback1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutP.add(feedback1);

		feedback2.setBounds(312, 160, 68, 18);
		feedback2.setFocusPainted(false);
		feedback2.setMargin(new Insets(0, 0, 0, 0));
		feedback2.setContentAreaFilled(false);
		feedback2.setBorderPainted(false);
		feedback2.setOpaque(false);
		feedback2.setVisible(false);
		feedback2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutP.add(feedback2);

		

		survey1.setBounds(225, 160, 81, 18);
		survey1.setFocusPainted(false);
		survey1.setMargin(new Insets(0, 0, 0, 0));
		survey1.setContentAreaFilled(false);
		survey1.setBorderPainted(false);
		survey1.setOpaque(false);
		survey1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutP.add(survey1);

		survey2.setBounds(225, 160, 81, 18);
		survey2.setFocusPainted(false);
		survey2.setMargin(new Insets(0, 0, 0, 0));
		survey2.setContentAreaFilled(false);
		survey2.setBorderPainted(false);
		survey2.setOpaque(false);
		survey2.setVisible(false);
		survey2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutP.add(survey2);

		
		timeredit.setBounds(260, 96, 13, 13);
		timeredit.setFocusPainted(false);
		timeredit.setMargin(new Insets(0, 0, 0, 0));
		timeredit.setContentAreaFilled(false);
		timeredit.setBorderPainted(false);
		timeredit.setOpaque(false);
		timeredit.setVisible(true);
		timeredit.setToolTipText("Edit Settings");
		timeredit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutP.add(timeredit);


		attribution.setBounds(364, 13, 14, 14);
		attribution.setFocusPainted(false);
		attribution.setMargin(new Insets(0, 0, 0, 0));
		attribution.setContentAreaFilled(false);
		attribution.setBorderPainted(false);
		attribution.setOpaque(false);
		attribution.setVisible(true);
		attribution.setToolTipText("Attribution");
		attribution.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutP.add(attribution);

		

		reportabug.setBounds(344, 12, 15, 16);
		reportabug.setFocusPainted(false);
		reportabug.setMargin(new Insets(0, 0, 0, 0));
		reportabug.setContentAreaFilled(false);
		reportabug.setBorderPainted(false);
		reportabug.setOpaque(false);
		reportabug.setVisible(true);
		reportabug.setToolTipText("Report A Bug!");
		reportabug.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutP.add(reportabug);


		
		
		specta.setText("<html> Developed By : <a href=\"\"><font color=\"#333\">Specta</a></html>");
		specta.setForeground(Color.DARK_GRAY);

		specta.setBounds(24, 146, 110, 20);
		specta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		specta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Desktop.getDesktop().browse(new URI("www.specta.in"));
				}
				catch (URISyntaxException | IOException ex)
				{
					// It looks like there's a problem
				}
			}
		});
		
		
		
		aboutP.add(specta);

		
		sankalp.setText("<html> Designed By : <a href=\"\"><font color=\"#333\">Sankalp Sinha</a></html>");
		sankalp.setForeground(Color.DARK_GRAY);

		sankalp.setBounds(24, 160, 140, 20);
		sankalp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sankalp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop()
							.browse(new URI("www.sankalpsinha.com"));
				} catch (URISyntaxException | IOException ex) {
					// It looks like there's a problem
				}
			}
		});

		aboutP.add(sankalp);

		aboutbody.setBounds(0, 0, 392, 191);

		aboutP.add(aboutbody);
		aboutP.setVisible(false);

		aboutS.setBounds(368,303, 167,130);
		cp.add(aboutS);
		aboutS.setFocusPainted(false);
		aboutS.setMargin(new Insets(0, 0, 0, 0));
		aboutS.setContentAreaFilled(false);
		aboutS.setBorderPainted(false);
		aboutS.setOpaque(false);
		aboutS.setVisible(false);
		// aboutS.setToolTipText("aboutS");

		aboutH.setBounds(382, 338, 139, 96);

		aboutH.setFocusPainted(false);
		aboutH.setMargin(new Insets(0, 0, 0, 0));
		aboutH.setContentAreaFilled(false);
		aboutH.setBorderPainted(false);
		aboutH.setVisible(false);
		aboutH.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutH.setOpaque(false);

		cp.add(aboutH);

		aboutU.setBounds(415, 349, 72, 70);
		cp.add(aboutU);
		aboutU.setFocusPainted(false);
		aboutU.setMargin(new Insets(0, 0, 0, 0));
		aboutU.setContentAreaFilled(false);
		aboutU.setBorderPainted(false);
		aboutU.setOpaque(false);
		// aboutU.setVisible(false);
		// aboutS.setToolTipText("aboutS");

		markerE.setBounds(-139, 295, 849, 152);
		cp.add(markerE);

		markerS.setBounds(-139, 295, 849, 152);
		cp.add(markerS);
		markerS.setVisible(false);

		markerA.setBounds(-139, 295, 849, 152);
		cp.add(markerA);
		markerA.setVisible(false);

		mkalogo.setBounds(40, 42, 148, 31);
		mkalogo.setFocusPainted(false);
		mkalogo.setMargin(new Insets(0, 0, 0, 0));
		mkalogo.setContentAreaFilled(false);
		mkalogo.setBorderPainted(false);
		mkalogo.setOpaque(false);
		mkalogo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		mkalogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("www.specta.in/mka"));
				} catch (URISyntaxException | IOException ex) {
					// It looks like there's a problem
				}
			}
		});

		cp.add(mkalogo);

		test.setBounds(368, 348, 200, 200);
		test.setFont(new Font(null, 0, 12));
		
		time.setBounds(473, 438, 50, 20);
		time.setFont(new Font("Open Sans", 0, 12));
		
		
		resetB.setBounds(295, 433, 60, 29);
		resetB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		resetH.setBounds(295, 433, 60, 29);
		resetH.setCursor(new Cursor(Cursor.HAND_CURSOR));
		resetH.setVisible(false);
		
		
		resetB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
					resetB.setVisible(false);
					resetH.setVisible(true);		
			}
		});
		
		resetH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TimerClass.clk=0;
				//TimerClass.timer.start();
				
				//TimerClass.clk=TimerClass.clk-(55*60);
				CountdownFrame.countdown.setVisible(false);
				
				System.out.println("TEST THIS");
			}
			public void mouseExited(MouseEvent e) {
					resetB.setVisible(true);
					resetH.setVisible(false);		
			}
		});
		
	
		cp.add(test);
		cp.add(time);
		cp.add(resetB);
		cp.add(resetH);
	
		
		
		cp.add(back);
		back.setBounds(10, 6, 550, 480);
		

		mp.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseDownCompCoords = null;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		mp.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				final MKA cp1 = new MKA();
				mp.setLocation(currCoords.x - mouseDownCompCoords.x,
						currCoords.y - mouseDownCompCoords.y);
			}
		});

		close.addActionListener(this);
		close.addMouseListener(this);

	
		exerciseS.addActionListener(this);
		exerciseS.addMouseListener(this);

		exerciseH.addMouseListener(this);
		exerciseH.addActionListener(this);

		exerciseU.addActionListener(this);
		exerciseU.addMouseListener(this);

		settingsS.addActionListener(this);
		settingsS.addMouseListener(this);

		settingsH.addMouseListener(this);
		settingsH.addActionListener(this);

		settingsU.addActionListener(this);
		settingsU.addMouseListener(this);

		aboutS.addMouseListener(this);
		aboutS.addActionListener(this);

		aboutH.addMouseListener(this);
		aboutH.addActionListener(this);
		aboutU.addMouseListener(this);
		aboutU.addActionListener(this);

		Eon1.addActionListener(this);
		Eon1.addMouseListener(this);
		Eon2.addActionListener(this);
		Eon2.addMouseListener(this);
		Eon3.addActionListener(this);
		Eon3.addMouseListener(this);

		Eoff1.addActionListener(this);
		Eoff1.addMouseListener(this);
		Eoff2.addActionListener(this);
		Eoff2.addMouseListener(this);
		Eoff3.addActionListener(this);
		Eoff3.addMouseListener(this);

		//Son1.addActionListener(this);
		//Son1.addMouseListener(this);
		Son2.addActionListener(this);
		Son2.addMouseListener(this);

		//Soff1.addActionListener(this);
		//Soff1.addMouseListener(this);
		Soff2.addActionListener(this);
		Soff2.addMouseListener(this);

		feedback1.addActionListener(this);
		feedback1.addMouseListener(this);
		feedback2.addActionListener(this);
		feedback2.addMouseListener(this);
		
		
		survey1.addActionListener(this);
		survey1.addMouseListener(this);
		survey2.addActionListener(this);
		survey2.addMouseListener(this);

		mkalogo.addActionListener(this);
		mkalogo.addMouseListener(this);
		
		timerup.addActionListener(this);
		timerdown.addActionListener(this);
		timerup.addMouseListener(this);
		timerdown.addMouseListener(this);
		
		timeredit.addActionListener(this);
		timeredit.addMouseListener(this);
		
		reportabug.addActionListener(this);
		reportabug.addMouseListener(this);
		
		
		attribution.addMouseListener(this);
		attribution.addActionListener(this);
		
		
		try
		{
			if(setting.getSetting("autoupdate"))
			{
				checkUpdate.readversion();
			}
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}

	}

	static MKA cpanel;

	public static void main(String args[])
	{
		mouseDownCompCoords = null;
		
		//final int PORT = 45;		// random large port number
	    final int PORT = 45343;
		
		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Windows".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (Exception e)
		{
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

	 
		// static initializer
		
			try
			{
				s = new ServerSocket(PORT, 10, InetAddress.getLocalHost());
				cpanel = new MKA();
				cpanel.assign();
				cpanel.initcontrolpanel();
				UserSettings setting = new UserSettings();
				setting.getTimerSetting("timer");
				System.out.println(setting.getTimerSetting("timer"));
				timervalue.setText(""+setting.getTimerSetting("timer"));
				
				TimerClass tc = new TimerClass();
				tc.schedule();
				SysTray notif = new SysTray();
				notif.notif();
				
				test.setVisible(true);
				time.setVisible(true);
				
				mp.repaint();
				mp.revalidate();

			}
			catch (Exception e)
			{
				// shouldn't happen for localhost
				// port taken, so app is already running
				JOptionPane.showMessageDialog(null, "App is already running in tray!");
				e.printStackTrace();
				
			}
	
			
		// main() and rest of application...
		
			}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		UserSettings setting = new UserSettings();
		
		setting.getTimerSetting("timer");
		System.out.println(setting.getTimerSetting("timer"));
		timervalue.setText(""+setting.getTimerSetting("timer"));
		
		
		
		if (ae.getSource() == close)
		{
			if (flag != 1)
			{
				flag = 1;			

			}

			frameflag = 0;
			mp.setVisible(false);
		}
		
	

		if (ae.getSource() == exerciseH) 
		{
			settingsS.setVisible(false);
			settingsU.setVisible(true);
			exerciseS.setVisible(true);
			exerciseU.setVisible(false);
			aboutS.setVisible(false);
			aboutU.setVisible(true);

			exerciseP.setVisible(true);
			settingsP.setVisible(false);
			aboutP.setVisible(false);

			markerE.setVisible(true);
			markerS.setVisible(false);
			markerA.setVisible(false);
			
			version.setVisible(false);

			mp.repaint();
			mp.revalidate();

			// marker.setBounds(-320,275,849,152);

		}

		if (ae.getSource() == settingsH || ae.getSource()==timeredit)
		{
			settingsS.setVisible(true);
			exerciseS.setVisible(false);
			exerciseU.setVisible(true);
			aboutS.setVisible(false);
			aboutU.setVisible(true);

			markerE.setVisible(false);
			markerS.setVisible(true);
			markerA.setVisible(false);
			
			version.setVisible(false);

			mp.repaint();
			mp.revalidate();

			exerciseP.setVisible(false);
			settingsP.setVisible(true);
			aboutP.setVisible(false);

		}
		if (ae.getSource() == aboutH) {
			settingsS.setVisible(false);
			exerciseS.setVisible(false);
			exerciseU.setVisible(true);
			aboutS.setVisible(true);
			aboutU.setVisible(false);
			version.setVisible(true);
			exerciseP.setVisible(false);
			settingsP.setVisible(false);
			aboutP.setVisible(true);

			// marker.setBounds(-20,275,849,152);

			markerE.setVisible(false);
			markerS.setVisible(false);
			markerA.setVisible(true);

			mp.repaint();
			mp.revalidate();

		}

		// off button click set --> value 1
		// on button click set--> value 0

		// ///////////////////////////// placing the settings
		if (ae.getSource() == Eon1) {

			//new MKA();
			MKA.getList();
			//new MKA();
			//new MKA();
			// JOptionPane.showMessageDialog(null,new ControlPanel().val[1] ||
			// new ControlPanel().val[2]);
			if (MKA.val[1] || MKA.val[2]) {

				setting.changeSetting("eye", false);
				Eon1.setVisible(false);
				Eoff1.setVisible(true);
				E1 = 0;
				System.out.println(E1);
			} else
				JOptionPane.showMessageDialog(null,
						"Atleast 1 exercise has to be selected");
		}
		if (ae.getSource() == Eon2) {
			//new MKA();
			MKA.getList();
			//new MKA();
			//new MKA();
			// JOptionPane.showMessageDialog(null,new ControlPanel().val[0] ||
			// new ControlPanel().val[2]);
			if (MKA.val[0] || MKA.val[2]) {

				setting.changeSetting("body", false);
				Eon2.setVisible(false);
				Eoff2.setVisible(true);
			} else
				JOptionPane.showMessageDialog(null,
						"Atleast 1 exercise has to be selected");
		}
		if (ae.getSource() == Eon3) {
			//new MKA();
			MKA.getList();
			//new MKA();
			//new MKA();
			// JOptionPane.showMessageDialog(null,new ControlPanel().val[0] ||
			// new ControlPanel().val[1]);
			if (MKA.val[0] || MKA.val[1]) {

				setting.changeSetting("water", false);
				Eon3.setVisible(false);
				Eoff3.setVisible(true);
			} else
				JOptionPane.showMessageDialog(null,
						"Atleast 1 exercise has to be selected");
		}

		if (ae.getSource() == Eoff1) {
			setting.changeSetting("eye", true);
			Eoff1.setVisible(false);
			Eon1.setVisible(true);
			E1 = 1;
			System.out.println(E1);

		}
		if (ae.getSource() == Eoff2) {

			setting.changeSetting("body", true);
			Eoff2.setVisible(false);
			Eon2.setVisible(true);

		}
		if (ae.getSource() == Eoff3) {

			setting.changeSetting("water", true);
			Eoff3.setVisible(false);
			Eon3.setVisible(true);

		}
		if (ae.getSource() == Son1)
		{
			setting.changeSetting("startup", false);
			Son1.setVisible(false);
			Soff1.setVisible(true);
		}
		
		if (ae.getSource() == Son2) {
			setting.changeSetting("autoupdate", false);
			Son2.setVisible(false);
			Soff2.setVisible(true);
		}
		if (ae.getSource() == Soff1) {
			setting.changeSetting("startup", true);
			Soff1.setVisible(false);
			Son1.setVisible(true);
		}
		if (ae.getSource() == Soff2) {
			setting.changeSetting("autoupdate", true);
			Soff2.setVisible(false);
			Son2.setVisible(true);
		}
		if (ae.getSource() == feedback2)
		{
			try
			{
				Desktop.getDesktop().browse(new URI("www.specta.in/mka#feedback"));
			}
			catch (Exception e){}
		}
		
		if (ae.getSource() == survey2)
		{
			try
			{
				Desktop.getDesktop().browse(new URI("www.specta.in/mka/survey.html"));
			}
			catch (Exception e){}
		}
		
		if(ae.getSource()==timerup)
		{
			
			if(timervalue.getText().equals("40"))
			{
			//JOptionPane.showMessageDialog(null, "It is 40");
				timervalue.setText("45");
				setting.changeTimerSettings("timer", 45);
				timerdown.setVisible(true);
				timerdownfade.setVisible(false);
				
			
			}	
			
			else if(timervalue.getText().equals("45"))
			{
			//JOptionPane.showMessageDialog(null, "It is 45");
				timervalue.setText("50");
				setting.changeTimerSettings("timer", 50);
				//JOptionPane.showMessageDialog(null, "It is "+TimerClass.clk);
				
			
			}	
			else if(timervalue.getText().equals("50"))
			{
			//JOptionPane.showMessageDialog(null, "It is 50");
				timervalue.setText("55");
				setting.changeTimerSettings("timer", 55);
				timerup.setVisible(false);
				timerupfade.setVisible(true);
			}
			else if(timervalue.getText().equals("55"))
			{
				//timervalue.setText("55");
				//JOptionPane.showMessageDialog(null, "Maximum interval for a reminder is 55 mins");
				timerup.setVisible(false);
				timerupfade.setVisible(true);
				
				
			}
			
			
			
			//timervalue.setText(""+timer[1]);
			
		}
		if(ae.getSource()==timerdown)
		{
			if(timervalue.getText().equals("40"))
			{

				//JOptionPane.showMessageDialog(null, "Minium interval for a reminder is 40 mins");
				timerdown.setVisible(false);
				timerdownfade.setVisible(true);
			
			}	
			
			if(timervalue.getText().equals("45"))
			{
				timervalue.setText("40");
				setting.changeTimerSettings("timer", 40);
				timerdown.setVisible(false);
				timerdownfade.setVisible(true);
				
			
			}	
			else if(timervalue.getText().equals("50"))
			{
				timervalue.setText("45");
				setting.changeTimerSettings("timer", 45);
			}
			else if(timervalue.getText().equals("55"))
			{
				timervalue.setText("50");
				setting.changeTimerSettings("timer", 50);
				timerup.setVisible(true);
				timerupfade.setVisible(false);
			}
			
		}
		
		if(ae.getSource()==reportabug)
		{
			
			try
			{
				Desktop.getDesktop().browse(new URI("mailto:hello@getmka.in?subject=Bug+Report"));
			}
			catch (Exception e){}
		}
		
		if(ae.getSource()==attribution)
		{
			try
			{
				Desktop.getDesktop().browse(new URI("www.specta.in/mka/credits.html"));
			}
			catch (Exception e){}
		}
		
		

	}


	

	@Override
	public void mouseEntered(MouseEvent me) {
		if (me.getSource() == close) {

			close.setBounds(500, 32, 24, 24);
			//closeH.setVisible(false);
		}
		if (me.getSource() == exerciseS) {

			// exerciseS.setBounds(75,335,139,96);

		}
		if (me.getSource() == exerciseU) {

			exerciseH.setVisible(true);

		}

		if (me.getSource() == settingsU) {

			settingsH.setVisible(true);

		}
		if (me.getSource() == aboutU) {
			aboutH.setVisible(true);

		}

		if (me.getSource() == Eon1) {

			Eon1.setBounds(347, 57, 73, 36);

		}
		if (me.getSource() == Eon2) {
			Eon2.setBounds(347, 117, 73, 36);

		}
		if (me.getSource() == Eon3) {
			Eon3.setBounds(347, 177, 73, 36);

		}

		if (me.getSource() == Eoff1)
		{

			Eoff1.setBounds(347, 57, 73, 36);

		}
		
		if (me.getSource() == Eoff2)
		{

			Eoff2.setBounds(347, 117, 73, 36);
		}
		
		if (me.getSource() == Eoff3) {

			Eoff3.setBounds(347, 177, 73, 36);
		}

		if (me.getSource() == Son1) {
			Son1.setBounds(347, 76, 73, 36);

		}
		if (me.getSource() == Son2) {

			Son2.setBounds(347, 177, 73, 36);
		}

		if (me.getSource() == Soff1) {

			Soff1.setBounds(347, 76, 73, 36);
		}
		if (me.getSource() == Soff2) {

			Soff2.setBounds(347, 177, 73, 36);
		}

		if (me.getSource() == feedback1) {

			feedback1.setVisible(false);
			feedback2.setVisible(true);
		}
		
		if (me.getSource() == survey1) {

			survey1.setVisible(false);
			survey2.setVisible(true);
		}

		if (me.getSource() == mkalogo) {

			// mkalogo.setOpaque(true);
		}
		if (me.getSource() == timeredit) {
			
			timeredit.setBounds(260, 95, 13, 13);

		}
		
		if(me.getSource()==reportabug)
		{
			reportabug.setBounds(344, 11, 15, 16);
		}
		if(me.getSource()==attribution)
		{
			attribution.setBounds(364, 12, 14, 14);

		}


	}

	@Override
	public void mouseExited(MouseEvent me) {
		
		
		if (me.getSource() == timeredit) {
			
			timeredit.setBounds(260, 96, 13, 13);

		}
				
		if (me.getSource() == close) {
			
			close.setVisible(true);
			close.setBounds(500, 33, 24, 24);

		}
		if (me.getSource() == exerciseS) {
			// exerciseS.setBounds(75,336,139,96);

		}
		if (me.getSource() == exerciseH) {
			exerciseH.setVisible(false);

		}
		if (me.getSource() == settingsH) {
			settingsH.setVisible(false);

		}
		if (me.getSource() == aboutH) {
			aboutH.setVisible(false);

		}

		if (me.getSource() == Eon1) {

			Eon1.setBounds(348, 57, 73, 36);
		}
		if (me.getSource() == Eon2) {

			Eon2.setBounds(348, 117, 73, 36);
		}
		if (me.getSource() == Eon3) {

			Eon3.setBounds(348, 177, 73, 36);
		}
		if (me.getSource() == Eoff1) {

			Eoff1.setBounds(348, 57, 73, 36);
		}
		if (me.getSource() == Eoff2) {
			Eoff2.setBounds(348, 117, 73, 36);

		}
		if (me.getSource() == Eoff3) {

			Eoff3.setBounds(348, 177, 73, 36);
		}

		if (me.getSource() == Son1) {

			Son1.setBounds(348, 76, 73, 36);
		}
		if (me.getSource() == Son2) {
			Son2.setBounds(348, 177, 73, 36);

		}

		if (me.getSource() == Soff1) {

			Soff1.setBounds(348, 76, 73, 36);
		}
		if (me.getSource() == Soff2) {

			Soff2.setBounds(348, 177, 73, 36);
		}

		if (me.getSource() == feedback2) {

			feedback2.setVisible(false);
			feedback1.setVisible(true);
		}
		
		if (me.getSource() == survey2) {

			survey2.setVisible(false);
			survey1.setVisible(true);
		}
		if(me.getSource()==reportabug)
		{
			reportabug.setBounds(344, 12, 15, 16);
		}
		if(me.getSource()==attribution)
		{
			attribution.setBounds(364, 13, 14, 14);

		}

	}
	
	
	
	

	static boolean[] val = new boolean[3];

	public static void getList() {
		val[0] = new UserSettings().getSetting("eye");
		val[1] = new UserSettings().getSetting("body");
		val[2] = new UserSettings().getSetting("water");
	}
	
	

	@Override
	public void mousePressed(MouseEvent me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// TODO Auto-generated method stub

	}
	public void mouseClicked(MouseEvent me){
		
		
	}
	

	public void activeFrame() {
		mp.setVisible(true);
	}

}
