package cybot.commands;

import cybot.Main;
import cybot.Options;
import cybot.enums.Color;
import cybot.util.UtilMessage;
import cybot.util.UtilURL;
import cybot.utils.Util;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Tweet {
	
	public Tweet(GuildMessageReceivedEvent event, String[] args) {
		if(args.length < 2) {
			UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
					UtilMessage.usageMessage("Kullanım: c.tweet <link>"));
			return;
		}
		if(!UtilURL.validateURL(args[1])) {
			UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
					UtilMessage.errorMessage("Tweet linki hatalı, lütfen kontrol edin."));
			return;
		}
		
		UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.tweetChannelID), args[1]);
		Util.log(Color.GREEN, "TWITTER BROADCAST", "Yeni bir tweet linki paylaşıldı. Link: " + args[1]);
	}

}
