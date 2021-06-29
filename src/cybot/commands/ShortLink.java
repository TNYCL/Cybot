package cybot.commands;

import java.util.Locale;

import cybot.Main;
import cybot.Options;
import cybot.enums.Color;
import cybot.shortlink.mysql.MySQL;
import cybot.util.UtilDate;
import cybot.util.UtilMessage;
import cybot.util.UtilURL;
import cybot.utils.Util;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class ShortLink {
	
	public ShortLink(GuildMessageReceivedEvent event, String[] args) {
		if(args.length < 3) {
			UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
					UtilMessage.usageMessage("Kullanım: c.shortlink <short-key> <link>"));
			return;
		}
		if(MySQL.hasShortLink(args[1])) {
			UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
					UtilMessage.errorMessage("Aynı isimde kısaltılmış link mevcut, lütfen başka bir kısaltım deneyin."));
			return;
		}
		if(!UtilURL.validateURL(args[2])) {
			UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
					UtilMessage.errorMessage("Kısaltılacak link hatalı, lütfen tekrar deneyin."));
			return;
		}
		
		MySQL.setShortLink(args[1], args[2]);
		
		UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
				UtilMessage.successMessage("Link başarıyla kısaltıldı.\n\n Kısaltma: "+Options.websiteLink+"?link="
		+args[1].toLowerCase(Locale.ENGLISH)+
		"\nYönlendirilen link: " + args[2] +
		" \n\nTarih: " + UtilDate.getTimeFromTimestamp(System.currentTimeMillis())));
		Util.log(Color.GREEN, "SHORTLINK SUCCESS", "Yeni bir link kısaltıldı. Kısaltım: "+args[1]+" Yönlendirilecek Link: " + args[2]);
	}

}
