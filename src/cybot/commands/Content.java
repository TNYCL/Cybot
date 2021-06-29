package cybot.commands;

import java.util.Locale;

import org.json.simple.JSONObject;

import cybot.Main;
import cybot.Options;
import cybot.enums.Color;
import cybot.module.Project;
import cybot.util.UtilDate;
import cybot.util.UtilJson;
import cybot.util.UtilMessage;
import cybot.utils.Util;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message.MentionType;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Content {
	
	public Content(GuildMessageReceivedEvent event, String[] args, String withoutArgs) {
		if(args.length < 2) {
			UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
					UtilMessage.usageMessage("Kullanım: c.content <link>"));
			return;
		}
		JSONObject projectJson = UtilJson.getProjectDetails(args[1]);
		if(projectJson == null) {
			Util.error("Proje detayları null olduğu için işlem return yedi.");
			return;
		}
		Project projectDetails = Project.getProjectDetails(projectJson);
		MessageBuilder builder = new MessageBuilder();
		builder.allowMentions(MentionType.EVERYONE);
		builder.append(" " + projectDetails.getName() + " out now! " + "@everyone");
		builder.append("\n");
		builder.append("\n");
		builder.append(projectDetails.getDescription());
		builder.append("\n");
		builder.append("\n");
		builder.append("Get it here: " + args[1]);
		builder.append("\n");
		
		UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.broadcastChannelID), builder.build());
		UtilMessage.sendChannelMessage(Main.getJDA().getTextChannelById(Options.commandChannelID), 
				UtilMessage.successMessage("Proje haberi başarıyla paylaşıldı. Tarih: " + UtilDate.getTimeFromTimestamp(System.currentTimeMillis())));
		Util.log(Color.GREEN, "CONTENT BROADCAST", "Yeni bir proje duyurusu paylaşıldı. Kategori:" + args[1].toUpperCase(Locale.ENGLISH) + " Link: " + args[1]);
	}

}
