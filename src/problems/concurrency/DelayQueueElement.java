package problems.concurrency;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueElement implements Delayed {

	@Override
	public int compareTo(Delayed o) {
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.toSeconds(10000L);
	}
}
