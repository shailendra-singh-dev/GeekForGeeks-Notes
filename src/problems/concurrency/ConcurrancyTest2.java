package problems.concurrency;

import java.io.IOException;

import problems.string.Permutations;
import problems.string.StringVsBytes;

public class ConcurrancyTest2 implements Runnable {

	public static void main(String[] args) {
		Thread[] stack = new Thread[] { new Thread(new ConcurrancyTest2()),
				new Thread(new ConcurrancyTest2()),
				new Thread(new ConcurrancyTest2()),
				new Thread(new ConcurrancyTest2()) };

		stack[0].start();
		stack[1].start();
		stack[2].run();
		stack[3].run();

		System.out.println("Done");
	}

	private void do_stuff() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		do_stuff();
	}

}
