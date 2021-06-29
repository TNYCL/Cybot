package cybot.util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class UtilMessage {
	
	public static void sendDirectMessage(User user, EmbedBuilder message) {
		user.openPrivateChannel().flatMap(channel -> channel.sendMessage(message.build())).queue();
	}
	
	public static void sendDirectMessage(User user, String message) {
		user.openPrivateChannel().flatMap(channel -> channel.sendMessage(message)).queue();
	}
	
	public static void sendChannelMessage(TextChannel channel, EmbedBuilder message) {
		channel.sendMessage(message.build()).queue();
	}
	
	public static void sendChannelMessage(TextChannel channel, Message message) {
		channel.sendMessage(message).queue();
	}
	
	public static void sendChannelMessage(TextChannel channel, String message) {
		channel.sendMessage(message).queue();
	}
	
	public static EmbedBuilder errorMessage(String message) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setColor(0xB61717);
		builder.setTitle("Hata");
		builder.setDescription(message);
		return builder;
	}
	
	public static EmbedBuilder usageMessage(String message) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setColor(0xD87200);
		builder.setTitle("Uyarı");
		builder.setDescription(message);
		return builder;
	}
	
	public static EmbedBuilder successMessage(String message) {
		EmbedBuilder builder = new EmbedBuilder();
		builder.setColor(0x22B404);
		builder.setTitle("Başarılı");
		builder.setDescription(message);
		return builder;
	}

}
