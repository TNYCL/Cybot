package cybot.util;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cybot.Main;
import cybot.Options;
import cybot.utils.Util;

public class UtilJson {
	
	public static JSONObject getProjectDetails(String url) {
		try {
			String splitedUrl = null;
			if(url.startsWith("https://www.minecraft.net/en-us/pdp?id=")) splitedUrl = url.replace("https://www.minecraft.net/en-us/pdp?id=", "");
			if(splitedUrl == null) {
				UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID),
						UtilMessage.errorMessage("Link değerini hatalı, lütfen kontrol edin."));
				return null;
			}
			String json;
			try {
				json = ClientBuilder.newClient().target("https://www.minecraft.net/bin/minecraft/productmanagement.productdetails.json?id=" + splitedUrl).request().accept(MediaType.APPLICATION_JSON).get(String.class);
			} catch(Exception e) {
				UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
						UtilMessage.errorMessage("Proje verileri bulunamadı, lütfen kontrol edin."));
				return null;
			}
			JSONParser parser = new JSONParser();
			return (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			Util.error(e.getMessage());
		}
		return null;
	}

}
