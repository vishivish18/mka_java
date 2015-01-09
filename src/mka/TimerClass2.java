package mka;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TimerClass2
{
	Timer timer, notiftimer;
	Timer countdown;
	
	String settings;

	Font customFont,customFont2,sizedFont1,sizedFont2;
	GraphicsEnvironment ge;
	
	JLabel eyeinstruction;
	JLabel walkinstruction1,walkinstruction2;
	JLabel waterinstruction;
	
	JLabel nextexer,nexttime1,nexttime2,nexttime3,endexer;

	int screen_count = 0;
	int counttime = 0;
	int clickcount = 0;
	
	UserSettings setting = new UserSettings();

	JFrame screen;
	JLabel eye, water, walk1, walk2;
	JLabel logo;
	JLabel topbck;
	JLabel click2continue1, click2continue2, click2continue3;
	JLabel click2quit;
	
	
	
	
	Container pane;
	JPanel panel;
	JTextField field;
	JPanel eye_panel, walk_panel, water_panel;
	JPanel bar;
	JLabel eyelabel, walklabel, waterlabel;

	static int count = 0;
	
	// frame function, calling this will capture the screen, add all the
	// exercises in this function after
	// checking the settings

	// ////////////////// mouse Listener //////////////////////
	MouseAdapter ml;

	int tic = 0;
	java.util.Timer ti;

	Toolkit tk = Toolkit.getDefaultToolkit();
	int xSize = ((int) tk.getScreenSize().getWidth());
	int ySize = ((int) tk.getScreenSize().getHeight());

	// ///////////// function snooze //////////////////////////
	public void snooze(long delay)
	{
		ti = new java.util.Timer();
		
		ti.schedule(new java.util.TimerTask()
		{
			@Override
			public void run()
			{	
				
				tic++;
				// //////////////////// count for the 1 and last timer // ////////////////////////////
				System.out.println(tic);
				
				nexttime1.setText(30-tic+"");
				nexttime2.setText(30-tic+"");
				nexttime3.setText(30-tic+"");
				
				//111
				
				if(setting.getSetting("eye") && setting.getSetting("body") && setting.getSetting("water"))
				{
						if(tic==1)
						{			
							if (counttime == 0)
							{
								eye_panel.setLayout(null);
								
								eyelabel.setVisible(true);
								walklabel.setVisible(false);
								waterlabel.setVisible(false);
								
								nextexer.setBounds(30, ySize - 110, 280, 49);
								eye_panel.add(nextexer);
								
								nexttime1.setBounds(254, ySize - 110, 280, 49);
								eye_panel.add(nexttime1);

								click2quit.setBounds(xSize - 210, ySize - 120, 181, 49);
								eye_panel.add(click2quit);
																
								screen.repaint();
								screen.validate();
							}
							
							if (counttime == 1)
							{
								walk_panel.setLayout(null);
								
								eyelabel.setVisible(false);
								walklabel.setVisible(true);
								waterlabel.setVisible(false);
								
								nextexer.setBounds(30, ySize - 110, 280, 49);
								walk_panel.add(nextexer);
								
								nexttime2.setBounds(254, ySize - 110, 280, 49);
								walk_panel.add(nexttime2);
								
								click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
								walk_panel.add(click2quit);
								
								screen.repaint();
								screen.validate();
							}
							
							if (counttime == 2)
							{
									water_panel.setLayout(null);
									
									eyelabel.setVisible(false);
									walklabel.setVisible(false);
									waterlabel.setVisible(true);
									
									endexer.setBounds(30, ySize - 110, 280, 49);
									water_panel.add(endexer);
									
									nexttime3.setBounds(197, ySize - 110, 280, 49);
									water_panel.add(nexttime3);
									
									click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
									water_panel.add(click2quit);
									
									screen.repaint();
									screen.validate();
	
							}
						}
						
						if (tic == 30)
						{
							counttime++;
							
							if (counttime == 1)
							{
								pane.remove(0);
								
								screen.repaint();
								screen.validate();
								
							}
	
							if (counttime == 2)
							{
								pane.remove(0);
								
								screen.repaint();
								screen.validate();
							}
							
							if (counttime == 3)
							{
								water_panel.setLayout(null);
							
								screen.repaint();
								screen.validate();
								
								ti.cancel();
								Mlistener();
							}							
							
							tic = 0;
							
						}
					}
						
						

/***************************************************************************************************/				

		
					//011
				
						if(!setting.getSetting("eye") && setting.getSetting("body") && setting.getSetting("water"))
						{							
								if(tic==1)
								{			
									if(counttime == 0)
									{
										counttime++;
									}
										
									if (counttime == 1)
									{
										walk_panel.setLayout(null);
										
										eyelabel.setVisible(false);
										walklabel.setVisible(true);
										waterlabel.setVisible(false);
										
										nextexer.setBounds(30, ySize - 110, 280, 49);
										walk_panel.add(nextexer);
										
										nexttime2.setBounds(254, ySize - 110, 280, 49);
										walk_panel.add(nexttime2);
										
										click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
										walk_panel.add(click2quit);
										
										screen.repaint();
										screen.validate();
										
									}
									
									if (counttime == 2)
									{										
											water_panel.setLayout(null);
											
											eyelabel.setVisible(false);
											walklabel.setVisible(false);
											waterlabel.setVisible(true);
											
											endexer.setBounds(30, ySize - 110, 280, 49);
											water_panel.add(endexer);
											
											nexttime3.setBounds(197, ySize - 110, 280, 49);
											water_panel.add(nexttime3);
											
											click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
											water_panel.add(click2quit);
											
											screen.repaint();
											screen.validate();
									}
								
								}
								
								if (tic == 30)
								{
									counttime++;
									
									if(counttime == 1){}
									
									if (counttime == 2)
									{
										pane.remove(0);
										
										screen.repaint();
										screen.validate();
									
									}
									
									if (counttime == 3)
									{
										
										water_panel.setLayout(null);
										
										screen.repaint();
										screen.validate();
										
										ti.cancel();
										Mlistener();
										
									}
									
									tic = 0;
								}
							}
						
						//100
						
						if(setting.getSetting("eye") && !setting.getSetting("body") && !setting.getSetting("water"))
						{												
								if(tic==1)
								{			
									if(counttime == 0)
									{
										eye_panel.setLayout(null);
										
										eyelabel.setVisible(true);
										walklabel.setVisible(false);
										waterlabel.setVisible(false);
										
										endexer.setBounds(30, ySize - 110, 280, 49);
										eye_panel.add(endexer);
										
										nexttime1.setBounds(197, ySize - 110, 280, 49);
										eye_panel.add(nexttime1);
										
										click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
										eye_panel.add(click2quit);
										
										screen.repaint();
										screen.validate();
										
									}
										
									if(counttime == 1)
									{
										counttime++;
									}
									
									if (counttime == 2)
									{										
										counttime++;
									}
								
								}
								
								if (tic == 30)
								{
									counttime++;
									
									if(counttime == 1)
									{
										eye_panel.setLayout(null);
										
										screen.repaint();
										screen.validate();
										
										ti.cancel();
										Mlistener();
			
									}
									
									if (counttime == 2){}
																		
									if (counttime == 3){}
									
									tic = 0;
						
								}
							}

						
						//110
						
						if(setting.getSetting("eye") && setting.getSetting("body") && !setting.getSetting("water"))
						{												
								if(tic==1)
								{			
									if(counttime == 0)
									{
										eye_panel.setLayout(null);
										
										eyelabel.setVisible(true);
										walklabel.setVisible(false);
										waterlabel.setVisible(false);
										
										nextexer.setBounds(30, ySize - 110, 280, 49);
										eye_panel.add(nextexer);
										
										nexttime1.setBounds(254, ySize - 110, 280, 49);
										eye_panel.add(nexttime1);
										
										click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
										eye_panel.add(click2quit);
										
										screen.repaint();
										screen.validate();
									}
										
									if(counttime == 1)
									{
										walk_panel.setLayout(null);
										
										eyelabel.setVisible(false);
										walklabel.setVisible(true);
										waterlabel.setVisible(false);
										
										endexer.setBounds(30, ySize - 110, 280, 49);
										walk_panel.add(endexer);
										
										nexttime2.setBounds(197, ySize - 110, 280, 49);
										walk_panel.add(nexttime2);
										
										click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
										walk_panel.add(click2quit);
										
										screen.repaint();
										screen.validate();
										
									}
									
									if (counttime == 2)
									{										
										counttime++;
									}
								
								}
								
								if (tic == 30)
								{
									counttime++;
									
									if(counttime == 1)
									{
										pane.remove(0);
										
										eye_panel.setLayout(null);
										
										screen.repaint();
										screen.validate();
			
									}
									
									if (counttime == 2)
									{										
										screen.repaint();
										screen.validate();
										
										ti.cancel();
										Mlistener();
									}
									
									if (counttime == 3){}
									
									tic = 0;								
								}
							}
						
						//101
						
						if(setting.getSetting("eye") && !setting.getSetting("body") && setting.getSetting("water"))
						{												
								if(tic==1)
								{			
									if(counttime == 0)
									{
										eye_panel.setLayout(null);
										
										eyelabel.setVisible(true);
										walklabel.setVisible(false);
										waterlabel.setVisible(false);
										
										nextexer.setBounds(30, ySize - 110, 280, 49);
										eye_panel.add(nextexer);
										
										nexttime1.setBounds(254, ySize - 110, 280, 49);
										eye_panel.add(nexttime1);
										
										click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
										eye_panel.add(click2quit);
										
										screen.repaint();
										screen.validate();
										
									}
										
									if(counttime == 1)
									{
										counttime++;
									}
									
									if (counttime == 2)
									{										
										water_panel.setLayout(null);
										
										eyelabel.setVisible(false);
										walklabel.setVisible(false);
										waterlabel.setVisible(true);
										
										endexer.setBounds(30, ySize - 110, 280, 49);
										water_panel.add(endexer);
										
										nexttime3.setBounds(197, ySize - 110, 280, 49);
										water_panel.add(nexttime3);
										
										click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
										water_panel.add(click2quit);
										
										screen.repaint();
										screen.validate();
		
									}
								
								}
								
								if (tic == 30)
								{
									counttime++;
									
									if(counttime == 1)
									{
										
										pane.remove(0);
										
										eye_panel.setLayout(null);
										
										screen.repaint();
										screen.validate();
			
									}
									
									if (counttime == 2){}
									
									if (counttime == 3)
									{
										
										water_panel.setLayout(null);
										
										screen.repaint();
										screen.validate();
										
										ti.cancel();
										Mlistener();
										
									}
									
									tic = 0;
									
								}
							}

						//001
						
						if(!setting.getSetting("eye") && !setting.getSetting("body") && setting.getSetting("water"))
						{												
								if(tic==1)
								{			
									if(counttime == 0)
									{
										counttime++;
									}
										
									if(counttime == 1)
									{
										counttime++;
									}
									
									if (counttime == 2)
									{										
										water_panel.setLayout(null);
										
										eyelabel.setVisible(false);
										walklabel.setVisible(false);
										waterlabel.setVisible(true);
										
										endexer.setBounds(30, ySize - 110, 280, 49);
										water_panel.add(endexer);
										
										nexttime3.setBounds(197, ySize - 110, 280, 49);
										water_panel.add(nexttime3);
										
										click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
										water_panel.add(click2quit);
										
										screen.repaint();
										screen.validate();
									}
								
								}
								
								if (tic == 30)
								{
									counttime++;
									
									if(counttime == 1){}
									
									if (counttime == 2){}
									
									if (counttime == 3)
									{
										water_panel.setLayout(null);
									
										screen.repaint();
										screen.validate();
										
										ti.cancel();
										Mlistener();
										
									}
									
									tic = 0;
									
								}
							}

						
						
						
						//010
						
						if(!setting.getSetting("eye") && setting.getSetting("body") && !setting.getSetting("water"))
						{												
								if(tic==1)
								{			
									if(counttime == 0)
									{
										counttime++;
									}
										
									if(counttime == 1)
									{
										walk_panel.setLayout(null);
										
										eyelabel.setVisible(false);
										walklabel.setVisible(true);
										waterlabel.setVisible(false);
										
										endexer.setBounds(30, ySize - 110, 280, 49);
										walk_panel.add(endexer);
										
										nexttime2.setBounds(197, ySize - 110, 280, 49);
										walk_panel.add(nexttime2);
										
										click2quit.setBounds(xSize - 210, ySize - 120,	181, 49);
										walk_panel.add(click2quit);
										
										screen.repaint();
										screen.validate();
									}
									
									if (counttime == 2)
									{										
										counttime++;
									}
								
								}
								
								if (tic == 30)
								{
									counttime++;
									
									if(counttime == 1){}
									
									if (counttime == 2)
									{
										walk_panel.setLayout(null);
										
										screen.repaint();
										screen.validate();
										
										ti.cancel();
										Mlistener();
									}
									
									if (counttime == 3){}
									
									tic = 0;
								
								}
							}

							Mlistener();
						
						}
			
		}, 1000, 1000);
		
	}

	// ///////////////////////// add mouse Listeners /////////////////////	

	public void Mlistener()
	{

		// /////////// take eye test //////////////////
		eye_panel.addMouseListener(ml);

		// //////////////// take a walk //////////////////////////

		walk_panel.addMouseListener(ml);
		// ///////////////////// water your hobbie
		// //////////////////////////////////

		water_panel.addMouseListener(ml);

	}

	// ///////////////////////// remove mouse Listeners /////////////////////

	public void rMlistener()
	{
		// /////////// take eye test //////////////////
		eye_panel.removeMouseListener(ml);

		// //////////////// take a walk //////////////////////////

		walk_panel.removeMouseListener(ml);
		// ///////////////////// water your hobbie	// //////////////////////////////////

		water_panel.removeMouseListener(ml);

	}

	static boolean key = false;

	public void BigFrame()
	{

		key = false;
		screen = new JFrame();
		pane = screen.getContentPane();
		panel = new JPanel();
		eye_panel = new JPanel();
		walk_panel = new JPanel();
		water_panel = new JPanel();
		bar = new JPanel();
		
		try
		{
			InputStream is1 = this.getClass().getResourceAsStream("/fonts/OS-Light.ttf");
			InputStream is2 = this.getClass().getResourceAsStream("/fonts/OS-Bold.ttf");
			
			customFont = Font.createFont(Font.TRUETYPE_FONT, is1);
			customFont2 = Font.createFont(Font.TRUETYPE_FONT, is2);
			
			sizedFont1 = customFont.deriveFont(36f);
			sizedFont2 = customFont2.deriveFont(18f);
		}
		catch (FontFormatException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}		  
		
		//check settings and add

		eye = new JLabel(new ImageIcon(getClass().getResource("/images/eyeleft.png")));
		walk1 = new JLabel(new ImageIcon(getClass().getResource(
				"/images/walk.png")));

		water = new JLabel(new ImageIcon(getClass().getResource("/images/waterglass.png")));
		logo = new JLabel(new ImageIcon(getClass().getResource("/images/mkalogo.png")));
		
		click2continue1 = new JLabel(new ImageIcon(getClass().getResource("/images/clicktoend.png")));
		click2continue2 = new JLabel(new ImageIcon(getClass().getResource("/images/clicktoend.png")));
		click2continue3 = new JLabel(new ImageIcon(getClass().getResource("/images/clicktoend.png")));
		
		click2quit = new JLabel(new ImageIcon(getClass().getResource("/images/clicktoend.png")));
		
		
		topbck = new JLabel(new ImageIcon(getClass().getResource("/images/topbck.png")));

		eyelabel = new JLabel(new ImageIcon(getClass().getResource("/images/eyename.png")));
		walklabel = new JLabel(new ImageIcon(getClass().getResource("/images/bodyname.png")));
		waterlabel = new JLabel(new ImageIcon(getClass().getResource("/images/watername.png")));

		eyeinstruction = new JLabel("Give your eyes some rest");
		
		walkinstruction1 = new JLabel("Leave your computer");
		walkinstruction2 = new JLabel("& have a walk");
		
		waterinstruction = new JLabel("Drink a glass of water");
		
		nextexer = new JLabel("Next exercise starts in : ");
		nextexer.setFont(sizedFont2);
		nextexer.setForeground(Color.WHITE);

		endexer = new JLabel("Exercise ends in : ");
		endexer.setFont(new Font(null, Font.BOLD, 18));
		endexer.setForeground(Color.WHITE);
		
		nexttime1 = new JLabel("");
		nexttime1.setFont(sizedFont2);
		nexttime1.setForeground(Color.WHITE);
		
		nexttime2 = new JLabel("");
		nexttime2.setFont(sizedFont2);
		nexttime2.setForeground(Color.WHITE);
		
		nexttime3 = new JLabel("");
		nexttime3.setFont(sizedFont2);
		nexttime3.setForeground(Color.WHITE);
		
		
		field = new JTextField(30);

		// eye_panel.add(field);

		eye_panel.setBounds(0, 50, xSize, ySize);
		eye_panel.setLayout(null);
		
		// walk_panel.add(field);
		walk_panel.setBounds(0, 50, xSize, ySize);
		walk_panel.setLayout(null);

		// water_panel.add(field);
		water_panel.setBounds(0, 50, xSize, ySize);
		water_panel.setLayout(null);

		// field.setBounds(600, 500, 100, 50);

		eye.setBounds((xSize / 2) - 350, (ySize / 2) - 250, 707, 340);
		eyeinstruction.setBounds(xSize/2-200, ySize-340, 500, 200);
		eyeinstruction.setForeground(Color.white);
		eyeinstruction.setFont(sizedFont1);		
		
		
		
		
		walk1.setBounds(550, 100, 207, 344);
		
		walkinstruction1.setBounds(xSize/2-200, 400, 800, 200);
		walkinstruction1.setForeground(Color.white);
		walkinstruction1.setFont(sizedFont1);
		
		walkinstruction2.setBounds(xSize/2-140, 460, 800, 200);
		walkinstruction2.setForeground(Color.white);
		walkinstruction2.setFont(sizedFont1);

		waterinstruction.setBounds(xSize/2-190, 400, 800, 200);
		waterinstruction.setForeground(Color.white);
		waterinstruction.setFont(sizedFont1);

		water.setBounds(xSize/2-150, 100, 265, 347);

		logo.setBounds(10, 10, 148, 31);

		eyelabel.setBounds(xSize - 190, 7, 178, 36);
		walklabel.setBounds(xSize - 190, 2, 180, 47);
		waterlabel.setBounds(xSize - 200, 5, 190, 42);

/********top bar in big frame*******/		
		
		bar.setBounds(0, 0, xSize, 60);
		bar.setLayout(null);
		
		bar.add(logo);
		bar.add(eyelabel);
		
		bar.add(walklabel);
		
		bar.add(waterlabel);

		topbck.setBounds(0, 0, xSize, 60);
		bar.setBackground(new Color(0,0,0,0));
		bar.add(topbck);
	

		eyelabel.setVisible(false);
		walklabel.setVisible(false);
		waterlabel.setVisible(false);		
		
		panel.setBounds(0, 60, xSize, ySize);
		
		

		ImageIcon img = new ImageIcon(getClass().getResource("/images/mka.png"));
		screen.setIconImage(img.getImage());

		MKA.getList();

		if (MKA.val[0])
		{
			pane.add(eye_panel);
			eye_panel.setBackground(new Color(0, 126, 62));
			eye_panel.add(eyeinstruction);
			eye_panel.add(eye);
		}
		
		new MKA();
		if (MKA.val[1])
		{
			pane.add(walk_panel);
			walk_panel.setBackground(new Color(34, 45, 66));
			walk_panel.add(walk1);
			walk_panel.add(walkinstruction1);
			walk_panel.add(walkinstruction2);
		}
		
		new MKA();
		if (MKA.val[2])
		{
			pane.add(water_panel);

			water_panel.setBackground(new Color(23, 120, 153));

			water_panel.add(water);

			water_panel.add(waterinstruction);
		}
		
		
		nexttime2.setBounds(240, ySize - 120, 280, 49);

		pane.add(bar);
		pane.add(panel);
		
		ml = new MouseAdapter()
		{
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				key = true;
				tic = 0;
				screen.setVisible(false);
			}
		};

		snooze(10);

		screen.setSize(xSize, ySize);

		screen.setUndecorated(true);
		screen.setVisible(true);
		screen.setAlwaysOnTop(true);
		screen.setResizable(false);
		screen.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		screen.setFocusTraversalKeysEnabled(false);
		// return key;
		
	}

	// scheduler function, schedules the frame default 40mins

}