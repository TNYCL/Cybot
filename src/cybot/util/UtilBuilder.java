package cybot.util;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed.Field;

public class UtilBuilder {
	
	public static EmbedBuilder buildEmbed(Color color, String title, String[] description, Field field) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setColor(color);
		builder.setTitle(title);
		builder.appendDescription(description.toString());
		builder.addField(field);
		return builder;
	}

}
