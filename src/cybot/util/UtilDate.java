package cybot.util;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.TimeZone;

public class UtilDate {
	
	public static String getDateFromTimestamp(long timestamp) {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		date.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/Istanbul")));
		return date.format(timestamp);
	}
	
	public static String getHourFromTimestamp(long timestamp) {
		SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
		date.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/Istanbul")));
		return date.format(timestamp);
	}
	
	public static String getTimeFromTimestamp(long timestamp) {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		date.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/Istanbul")));
		return date.format(timestamp);
	}

}
