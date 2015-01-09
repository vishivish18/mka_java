package mka;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class SysTray extends MKA {

	public static TrayIcon trayIcon;
	SystemTray tray;
	PopupMenu popup;

	MenuItem aboutItem;
	MenuItem showItem;
	MenuItem exitItem;

	public SysTray()
	{
		// checking if system tray is supported
		if (SystemTray.isSupported()) 
		{
			// JOptionPane.showMessageDialog(null, "System Tray Supported");
			setOnTray(); // yes --> call function

		}
		else
		{
			System.out.println("not");
		}
	}

	public void notif()
	{
		trayIcon.displayMessage("MKA",
				"Your settings have been configured and mka will run accordingly. Click on the tray icon to change settings",
				TrayIcon.MessageType.INFO);
		
	}

	public void setOnTray()
	{
		popup = new PopupMenu();

		trayIcon = new TrayIcon(new ImageIcon(getClass().getResource("/images/trayicon.png"), "tray icon").getImage());

		tray = SystemTray.getSystemTray();

		// Create a pop-up menu components
		aboutItem = new MenuItem("About");
		showItem = new MenuItem("Show");
		exitItem = new MenuItem("Exit");

		// Add components to pop-up menu
		popup.add(showItem);
		popup.addSeparator();
		popup.add(aboutItem);
		popup.addSeparator();
		popup.add(exitItem);

		trayIcon.setPopupMenu(popup);
		trayIcon.setToolTip("MKA");
		trayIcon.displayMessage("", "Time Remaining"+MKA.time,MessageType.INFO);

		try
		{
			tray.add(trayIcon);

		}
		catch (AWTException e)
		{
			System.out.println("TrayIcon could not be added.");
		}

		MenuHandler handler = new MenuHandler();
		exitItem.addActionListener(handler);
		showItem.addActionListener(handler);
		aboutItem.addActionListener(handler);
		
		MHandler mhandler = new MHandler();
		trayIcon.addActionListener(mhandler);
		
	}
	
	private class MHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == trayIcon)
			{
				mp.setVisible(true);
				mp.repaint();
			}
		}
	}


	private class MenuHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == exitItem)
			{
				System.exit(0);
			}
			else if (e.getSource() == showItem)
			{
				mp.setVisible(true);
				mp.repaint();

			}
			else if (e.getSource() == aboutItem)
			{
				mp.setVisible(true);
				mp.repaint();
				
				aboutcp();

			}
		}
	}
	
	
	
}
