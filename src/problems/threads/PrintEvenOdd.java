package problems.threads;

public class PrintEvenOdd {

	public class PrintThread implements Runnable{

		private final Print print =new Print();
		private int i ;
		private int max;
		
		public PrintThread(int max) {
			this.max = max;
		}
		
		@Override
		public void run() {
			while(i < max) {
				if(i %2 == 0) {
					print.printEven(i);
				}else {
					print.printOdd(i);
				}
				i++;
			}
		}
	}
	
	public class Print {
		volatile private boolean isOdd;
		
		synchronized public void printEven(int n) {
			while(isOdd) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+n);
			isOdd = false;
			notifyAll();
		}
		
		synchronized public void printOdd(int n) {
			while(!isOdd) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+n);
			isOdd = true;
			notifyAll();
		}
	}
	
	public void test() {
		Thread t1=new Thread(new PrintThread(10),"Even");
		Thread t2=new Thread(new PrintThread(10),"Odd");
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
