package cybot.utils;

import cybot.enums.Color;
import cybot.util.UtilDate;

public class Util {
	
	private static String time(Object msg) {
		return "[" + UtilDate.getHourFromTimestamp(System.currentTimeMillis()) + "]: " + msg;
	}
	
	public static void info(Object msg) {
		System.out.println(time(Color.get(Color.YELLOW) + "[INFO] " + Color.get(Color.RESET) + msg));
	}
	
	public static void warning(Object msg) {
		System.out.println(time(Color.get(Color.YELLOW) + "[WARNING] " + Color.get(Color.RESET) + msg));
	}
	
	public static void error(Object msg) {
		System.out.println(time(Color.get(Color.RED) + "[ERROR] " + Color.get(Color.RESET) + msg));
	}
	
	public static void log(Color color, String sender, Object msg) {
		System.out.println(time(Color.get(color) + "[" + sender + "] " + Color.get(Color.RESET) + msg));
	}

}
