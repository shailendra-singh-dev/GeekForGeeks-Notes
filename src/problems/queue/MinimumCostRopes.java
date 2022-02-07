package problems.queue;

import java.util.PriorityQueue;

public class MinimumCostRopes {

	PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

	private int getMinimumCost(int[] a) {
		if (null == a || a.length == 0) {
			return -1;
		}

		for (int i = 0; i < a.length; i++) {
			priorityQueue.offer(a[i]);
		}

		int res = 0;
		while (priorityQueue.size() > 1) {
			int p = priorityQueue.poll();
			int q = priorityQueue.poll();
			res += (p + q);
			System.out.println("p:"+p+",q:"+q+",res:"+res);
			priorityQueue.offer(p + q);
		}
		return res;
	}
	
	private int getMinRopeLength(int[] a) {
		for (int i = 0; i < a.length; i++) {
			priorityQueue.offer(a[i]);
		}
		while (priorityQueue.size() > 1) {
			int b = priorityQueue.poll();
			int c = priorityQueue.poll();
			priorityQueue.offer(b + c);
		}
		return priorityQueue.poll();
	}

	public static void test() {
		MinimumCostRopes costRopes = new MinimumCostRopes();
		System.out.println("Min cost:" + costRopes.getMinRopeLength(new int[] { 4, 3, 6, 2 }));

	}
}
