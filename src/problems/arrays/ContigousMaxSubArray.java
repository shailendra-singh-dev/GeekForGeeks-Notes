package problems.arrays;

import java.util.Arrays;

public class ContigousMaxSubArray {

	private int max_ending_here = 0;
	private int max_so_far = Integer.MIN_VALUE;

	//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

	
	
	 public int solutionA(int[] A) {
         // initial setting A[0]
       int currentSum = Integer.MIN_VALUE + 1000001;
       int maxSum = Integer.MIN_VALUE + 1000001;

       // note: for i=0, it will return A[0] (also for "one element" cases)  
          
       for(int a :A){
            currentSum = Math.max(currentSum +a , a); // <--- key point~!!            
            maxSum = Math.max(maxSum, currentSum); // update the max (be careful)
           
       }
       
       return maxSum; // can be used for "all negative" cases 
   }

	 
	private int getMaxSumV1(int[] a) {
		if (null == a || a.length == 0) {
			return -1;
		}
		for (int i = 0; i < a.length; i++) {
			max_ending_here = a[i] + max_ending_here;
			if (max_ending_here < 0) {
				max_ending_here = 0;
			} else if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}

	// It handles case when all numbers are negative.
	private int current_max = 0;

	private int getMaxSumV2(int[] a) {
		if (null == a || a.length == 0) {
			return -1;
		}
		for (int i = 0; i < a.length; i++) {
			current_max = Math.max(a[i], current_max + a[i]);
			max_so_far = Math.max(current_max, max_so_far);
		}
		return max_so_far;
	}

	private int[] getMaxSumSubArray(int[] a) {
		if (null == a || a.length == 0) {
			return null;
		}
		int start = 0, s = 0, end = 0;
		for (int i = 0; i < a.length; i++) {
			max_ending_here = a[i] + max_ending_here;
			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1 ;
			} else if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}
		}

		System.out.println("satrt :" + start + ",end:" + end);
		int[] subArray = new int[end - start + 1];
		int j = 0;
		for (int i = start; i <= end; i++) {
			subArray[j++] = a[i];
		}
		return subArray;
	}

	public static void test() {
		int[] a = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		ContigousMaxSubArray contigousMaxSubArray = new ContigousMaxSubArray();
//		System.out.println("getMaxSumSubArray:" + Arrays.toString(contigousMaxSubArray.getMaxSumSubArray(a)));
		System.out.println("getMaxSumV2:"+ contigousMaxSubArray.getMaxSumV2(a));
	}
}
