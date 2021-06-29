package cybot.listener;

import cybot.Main;
import cybot.Options;
import cybot.commands.Content;
import cybot.commands.ShortLink;
import cybot.commands.Tweet;
import cybot.enums.Color;
import cybot.util.UtilMessage;
import cybot.utils.Util;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(event.getAuthor().getName().equals("Cybot")) return;
		
		String[] args = event.getMessage().getContentRaw().split(" ");
		StringBuilder withoutArgs = new StringBuilder();
		boolean hasPermission = event.getMember().hasPermission(Permission.ADMINISTRATOR);
		
		if(args[0].startsWith(Options.prefix) && !hasPermission) Util.log(Color.RED, "USE ADMIN COMMAND", event.getMessage().getContentRaw());
		else Util.log(Color.YELLOW, event.getAuthor().getName(), event.getMessage().getContentRaw());
		
		for(String message : args) {
			if(message.startsWith(Options.prefix)) continue;
			withoutArgs.append(" " + message);
		}
		
		if(args[0].startsWith(Options.prefix) && hasPermission && !event.getChannel().getId().equals(Options.commandChannelID)) {
			event.getMessage().delete().queue();
			UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
					UtilMessage.errorMessage("Bot komutları sadece bu kanalda kullanılabilir."));
			return;
		}
		
		if(args[0].equalsIgnoreCase(Options.prefix + "content")) {
			new Content(event, args, withoutArgs.toString());
		}
		if(args[0].equalsIgnoreCase(Options.prefix + "tweet")) {
			new Tweet(event, args);
		}
		if(args[0].equalsIgnoreCase(Options.prefix + "shortlink")) {
			new ShortLink(event, args);
		}
	}
	
}


















