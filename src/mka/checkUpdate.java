package mka;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class checkUpdate 
{
	public static void readversion()
	{
		try 
		{
			   URL url = new URL("http://www.specta.in/mka/check.txt");
			   Scanner s = new Scanner(url.openStream());
			   int test =s.nextInt();
			   
			   //System.out.println(test);
			   
			   if(test > MKA.mkaversion)
			   {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null,"A new version is available \nDo you want to download?", "Update Check", dialogButton);
					
					if(dialogResult==0)
					{
						try
						{
							java.awt.Desktop.getDesktop().browse(new URI("http://www.getmka.in"));
						}
						catch (URISyntaxException e)
						{
							e.printStackTrace();
						}
					}
					else
					{
						
					}
			   }
			   // read from your scanner
			   
		}
		catch(IOException ex)
		{
			   // there was some connection problem, or the file did not exist on the server,
			   // or your URL was not in the right format.
			   // think about what to do now, and put it here.
				System.out.println("Unable to connect to internet");
			   ex.printStackTrace(); // for now, simply output it.
			}
	}

	private void extracted()
	{
		JOptionPane.showMessageDialog(null,	"Configuration Saved ! Mka will be running in tray");
	}

}