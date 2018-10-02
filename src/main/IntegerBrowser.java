package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntegerBrowser {

	private static int totalTime = 0;

	public static void test() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			if(!( N > 0 && N <= 1000)){
				return;
			}
			for (int i = 0; i < N; i++) {
				String[] line1 = br.readLine().split(" ");
				int totalFiles = Integer.parseInt(line1[0]);
				if(!(totalFiles>0 && totalFiles<=10000)){
					return;
				}
				
				int totalDownloadSpeed = Integer.parseInt(line1[1]);
				if(!(totalDownloadSpeed > 0 && totalDownloadSpeed <=30000)){
					return;
				}

				String[] line2 = br.readLine().split(" ");
				int[] a = new int[totalFiles];
				for (int j = 0; j < totalFiles; j++) {
					a[j] = Integer.parseInt(line2[j]);
					int fileSize = a[j];
					if(!(fileSize > 0 && fileSize < 100000)){
						return;
					}					
				}

				int timeToDownload = getTime(totalDownloadSpeed, a);
				System.out.println(timeToDownload);
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private static int getTime(int totalDownloadSpeed, int[] a) {
		a = quickSort(a, 0, a.length-1);//bubbleSort(a);
		int lowestItem = getLowestFileSize(a);
		int speedForEachFile = (int) Math.floor((double)((double)totalDownloadSpeed / (double)getNonZeroElementsCount(a)));
		int timeToDownload = (int) Math.ceil((double)((double)lowestItem / (double)speedForEachFile));
//		System.out.println("speedForEachFile:" + speedForEachFile + ",timeToDownload:" + timeToDownload);
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] - lowestItem;
			if (0 > a[i]) {
				a[i] = 0;
			}
		}
//		System.out.println(speedForEachFile + " " + timeToDownload + " "+Arrays.toString(a));
		if (isAllElementsZero(a)) {
			return timeToDownload;
		} else {
			totalTime = timeToDownload + getTime(totalDownloadSpeed, a); 
			return totalTime;
		}
	}

	private static int getLowestFileSize(int[] array) {
		array = quickSort(array, 0, array.length-1);//bubbleSort(array);
		for (int i = 0; i < array.length; i++) {
			if (0 != array[i]) {
				return array[i];
			}
		}
		return -1;
	}

	private static boolean isAllElementsZero(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				return false;
			}
		}
		return true;
	}

	private static int getNonZeroElementsCount(int[] a) {
		int count =0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				count++;
			}
		}
		return count;
	}
	
	public static int[] bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}

	public static int[] quickSort(int[] array, int low, int high) {
		if (low >= high || high > array.length || array.length == 0) {
			return null;
		}

		// pick the pivot
		int middle = low + (high - low) / 2;
		 int pivot = array[middle];
		 //int pivot = array[low];
         //int pivot = array[high];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(array, low, j);
		if (i < high)
			quickSort(array, i, high);
		
		return array;
	}
}
