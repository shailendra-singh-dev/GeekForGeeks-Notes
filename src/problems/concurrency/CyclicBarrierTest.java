package problems.concurrency;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public  void test() {
		int parties = 2;
		
		Runnable barrierAction1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Barrier 1 has reached..");
			}
		};
		CyclicBarrier cyclicBarrier1 = new CyclicBarrier(parties, barrierAction1);

		Runnable barrierAction2 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Barrier 2 has reached..");
			}
		};
		CyclicBarrier cyclicBarrier2 = new CyclicBarrier(parties, barrierAction2);		

		CyclicBarrierTask cyclicBarrierTask1=new CyclicBarrierTask(cyclicBarrier1, cyclicBarrier2);
		CyclicBarrierTask cyclicBarrierTask2=new CyclicBarrierTask(cyclicBarrier1, cyclicBarrier2);

		cyclicBarrierTask1.start();
		cyclicBarrierTask2.start();		
	}

	private class CyclicBarrierTask extends Thread {

		private CyclicBarrier mCyclicBarrier1;
		private CyclicBarrier mCyclicBarrier2;

		public CyclicBarrierTask(CyclicBarrier cyclicBarrier1,
				CyclicBarrier cyclicBarrier2) {
			mCyclicBarrier1 = cyclicBarrier1;
			mCyclicBarrier2 = cyclicBarrier2;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println("" + Thread.currentThread().getName()
						+ " is waiging on Cyclic Barrier1");
				mCyclicBarrier1.await();
				
				System.out.println("" + Thread.currentThread().getName()
						+ " is waiging on Cyclic Barrier2");
				mCyclicBarrier2.await();
							
				System.out.println("" + Thread.currentThread().getName()
						+ " is finished execution");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
