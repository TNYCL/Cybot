package cybot;

import java.util.Arrays;
import java.util.List;

public class Options {
	
	public static String pullLink = "https://www.tnycl.com/";
	
	public static String token = null;
	public static String prefix = "c.";
	
	public static String tweetChannelID = "853559135642583043";
	public static String broadcastChannelID = "853767722827251753";
	public static String commandChannelID = "853995805592256553";
	
	public static String sqlIP = null;
	public static String sqlPort = null;
	public static String sqlPassword = null;
	public static String sqlDatabase = null;
	public static String sqlUser = null;
	
	public static int activityChangeSeconds = 60;
	
	public static List<String> activityList = Arrays.asList(new String[] {
			"Minecraft"
	});

}
