package problems.threads;

public class PrintEvenOdd {

	/*
	 * https://java2blog.com/print-even-odd-numbers-threads-java/
	 * 
	 */
	public class Printer {

		boolean odd;
		int count = 1;
		int MAX = 20;

		public void printOdd() {
			synchronized (this) {
				while (count < MAX) {
					System.out.println("Checking odd loop");

					while (!odd) {
						try {
							System.out.println("Odd waiting : " + count);
							wait();
							System.out.println("Notified odd :" + count);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("Odd Thread :" + count);
					count++;
					odd = false;
					notify();
				}
			}
		}

		public void printEven() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			synchronized (this) {
				while (count < MAX) {
					System.out.println("Checking even loop");

					while (odd) {
						try {
							System.out.println("Even waiting: " + count);
							wait();
							System.out.println("Notified even:" + count);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("Even thread :" + count);
					count++;
					odd = true;
					notify();
				}
			}
		}
	}

	public void test() {
		final Printer printer = new Printer();
		printer.odd = true;

		Thread t1 = new Thread("Even") {

			@Override
			public void run() {
				printer.printEven();
			}
		};
		Thread t2 = new Thread("Odd") {

			@Override
			public void run() {
				printer.printOdd();
			}
		};

		// Thread t1 = new Thread(new OddEvenRunnable(0), "Even");
		// Thread t2 = new Thread(new OddEvenRunnable(1), "Odd");
		
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
