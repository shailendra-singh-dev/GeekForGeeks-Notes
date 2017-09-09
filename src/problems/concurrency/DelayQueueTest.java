package problems.concurrency;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {

	public static void test() {

		DelayQueue<DelayQueueElement> delayQueue = new DelayQueue<DelayQueueElement>();

		DelayQueueElement delayQueueElement = new DelayQueueElement();
		delayQueue.put(delayQueueElement);

		try {
			DelayQueueElement delayQueueElement2 = delayQueue.take();
			System.out.println("delayQueueElement2:" + delayQueueElement2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
