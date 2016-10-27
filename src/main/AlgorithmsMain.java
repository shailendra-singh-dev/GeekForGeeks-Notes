package main;

import java.util.Arrays;

import javax.sound.sampled.ReverbType;

import arrays.BinarySearch;
import arrays.BubbleSort;
import arrays.PrimeNumbers;
import arrays.QuickSort;
import arrays.Stack;
import arrays.StringReverse;
import arrays.SumOfDigits;

public class AlgorithmsMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] array = new int[] { 30, 6, -2, 0, 9, 10 };
	QuickSort.quickSort(array, 0, array.length - 1);
	BubbleSort.bubbleSort(array);
	System.out.print("quickSort :" + Arrays.toString(array));
    }
}
