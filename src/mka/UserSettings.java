package mka;

import java.util.prefs.Preferences;

public class UserSettings {

	final static Preferences prefsRoot = Preferences.userRoot();
	static Preferences prefs = prefsRoot
			.node("com.myapp.preference.staticPreferenceLoader");

	public void DefSettings()
	{

		prefs.putBoolean("eye", true);
		prefs.putBoolean("body", true);
		prefs.putBoolean("water", true);
		prefs.putBoolean("startup", true);
		prefs.putBoolean("autoupdate", true);
		prefs.putInt("timer",40);
	}

	public void changeSetting(String type, Boolean value)
	{
		prefs.putBoolean(type, value);
	}
	
	public void changeTimerSettings(String type, int value)
	{
		prefs.putInt(type, value);
		
	}

	public boolean getSetting(String type)
	{
		return prefs.getBoolean(type, true);
	}
	
	public int getTimerSetting(String type)
	{
		return prefs.getInt(type,40);
	}

}
