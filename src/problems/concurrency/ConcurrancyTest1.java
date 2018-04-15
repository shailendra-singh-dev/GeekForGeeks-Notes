package problems.concurrency;

import java.io.IOException;

import problems.string.Permutations;
import problems.string.StringVsBytes;

public class ConcurrancyTest1 {

	public static void main(String[] args) {

		Thread t1 = new Thread() {
			public void run() {
				ConcurrancyTest1 algorithmsMain = new ConcurrancyTest1();
				algorithmsMain.m1();
			};
		};

		Thread t2 = new Thread() {
			public void run() {
				ConcurrancyTest1 algorithmsMain = new ConcurrancyTest1();
				algorithmsMain.m2();
			};
		};

		t1.start();
		t2.start();
		System.out.println("Done");
	}

	private synchronized static void m1() {
		do_stuff();
	}

	public synchronized static void m2() {
		do_stuff();
	}

	private synchronized static void do_stuff() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
