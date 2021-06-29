package cybot.scheduler;

import java.util.Timer;
import java.util.TimerTask;

import cybot.Options;
import cybot.util.UtilActivity;

public class ActivityScheduler {
	
	public int activitySize = Options.activityList.size();
	public int queue = -1;

	public ActivityScheduler() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(queue+1 == activitySize) queue = 0;
				else queue++;
				UtilActivity.setActivity(Options.activityList.get(queue));
			}
		}, 1000, 1000*Options.activityChangeSeconds);
	}
	
	public void setQueue(int queue) {
		this.queue = queue;
	}
	
}
