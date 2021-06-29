package cybot.util;

public class UtilURL {
	
	public static boolean validateURL(String url) {
		if(url.startsWith("https://")) return true;
		return false;
	}

}
