package main;

import java.util.Arrays;

import arrays.SelectionSort;


public class AlgorithmsMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] array = new int[] { 5, 9, 0, 1, -1 };
	System.out.println("array:" + Arrays.toString(array));
	System.out.println(Arrays.toString(SelectionSort.selectionSort(array)));
    }
}
