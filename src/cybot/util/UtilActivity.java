package cybot.util;

import cybot.Main;
import net.dv8tion.jda.api.entities.Activity;

public class UtilActivity {
	
	public static void setActivity(String activity) {
		Main.getJDABuilder().setActivity(Activity.playing(activity));
	}

}
