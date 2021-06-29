package cybot;

import javax.security.auth.login.LoginException;

import cybot.listener.CommandListener;
import cybot.scheduler.ActivityScheduler;
import cybot.scheduler.RebootScheduler;
import cybot.shortlink.mysql.MySQL;
import cybot.utils.Util;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {
	
	public static MySQL mysql;
	public static ActivityScheduler activityScheduler;
	
	public static JDABuilder jdaBuilder;
	public static JDA jda;
	
	public static void main(String[] args) {
		jdaBuilder = JDABuilder.createDefault(Options.token);
		mysql = new MySQL();
		setup();
	}
	
	private static void setup() {
		registerListener();
		activityScheduler = new ActivityScheduler();
		new RebootScheduler(System.currentTimeMillis());
		try {
			jda = jdaBuilder.build();
		} catch (LoginException e) {
			Util.error("Bot başlatılırken bir sorun meydana geldi.");
		}
	}
	
	private static void registerListener() {
		jdaBuilder.addEventListeners(new CommandListener());
	}
	
	public static MySQL getSQL() {
		return mysql;
	}
	
	public static ActivityScheduler getActivityScheduler() {
		return activityScheduler;
	}
	
	public static JDABuilder getJDABuilder() {
		return jdaBuilder;
	}
	
	public static JDA getJDA() {
		return jda;
	}

}
