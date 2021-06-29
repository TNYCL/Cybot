package cybot.scheduler;

import java.util.Timer;
import java.util.TimerTask;

import cybot.util.UtilProcess;

public class RebootScheduler {
	
	public RebootScheduler(long timestamp) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(timestamp+1000*24*60*60 <= System.currentTimeMillis()) UtilProcess.killRunTime();
			}
		}, 1000, 1000);
	}

}
