package mka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JFrame;

public class TimerClass extends JFrame
{
	
	static javax.swing.Timer timer;

	Timer countdown;
	
	int timervaluec = Integer.parseInt(MKA.timervalue.getText()); 
	
	//int timervaluec = 55;
	

	static int remtime; // remaining time for displaying on control panel

	static javax.swing.Timer chk; // //////////////// check for the clock
							// /////////////////////////

	// frame function, calling this will capture the screen, add all the
	// excercises in this function after
	// checking the settings

	// scheduler function, schedules the frame default 40mins
	static int clk = 0;
	int tclk = 0;

	public static void snooze()
	{
		clk=clk-(10*60);/////////re do this line after testing.
		//clk = clk-(20*60);
		
	}

	public void schedule() // this function schedules the default 55 mins for
							// excercise counter
	{

		// this time will run the actionPerformed each second as 1000 is passed
		// as parameter

		timer = new javax.swing.Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (clk == ((timervaluec * 60) - 30)) {///////////change 1 to 55
					CountdownFrame cd = new CountdownFrame();
					cd.initcountdown();
					cd.countercall();
				}

				if (clk == (timervaluec * 60)) {/////////////change 1 to 55
					timer.stop();

					new TimerClass2().BigFrame();

					chk = new javax.swing.Timer(1000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent ew)
						{

							if (TimerClass2.key) 	//if excercises completed then
													// key would be false and
													// again timer would be
													// started
							{
								clk = 0;
								timer.start();
								timervaluec = Integer.parseInt(MKA.timervalue.getText()); 
								chk.stop();
							}
						}
					});

					chk.start();

				}

				clk++;

				remtime =timervaluec * 60 - clk; // remaining time on control panel /////////change 1 to 55

				if (remtime < 60)
				{
					MKA.time.setText(remtime+1 + " sec");
				}
				else if (remtime > 60 && remtime < 120)
				{
					MKA.time.setText((remtime / 60) + " min");
				} 
				else
				{
					MKA.time.setText((remtime / 60) + " mins");
				}
				
			}
		});

		timer.start();

	}

}


