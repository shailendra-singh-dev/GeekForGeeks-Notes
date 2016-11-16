package main;

import java.util.Arrays;

import javax.sound.sampled.ReverbType;

import arrays.BinarySearch;
import arrays.BubbleSort;
import arrays.InsertionSort;
import arrays.LinkedList;
import arrays.Node;
import arrays.PrimeNumbers;
import arrays.QuickSort;
import arrays.Stack;
import arrays.StringReverse;
import arrays.SumOfDigits;
import arrays.ValidParenthesis;

public class AlgorithmsMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
//	System.out.print("isParenthesisMatchedUsingStack:"+ValidParenthesis.isParenthesisMatchedUsingStack("[()]{}{[()()]()}") +"\n");
//	System.out.print("isParenthesisMatchedUsingHashMap:"+ValidParenthesis.isParenthesisMatchedUsingHashMap("[()]{}{[()()]()}"));
	int[] array = new int[]{5,9,0,1,-1};
//	System.out.print(""+Arrays.toString(array));
//	BubbleSort.bubbleSort(array);
//	System.out.print(""+Arrays.toString(array));
	
	
	System.out.println("array:"+Arrays.toString(array));
	System.out.println(Arrays.toString(InsertionSort.insertionSort(array)));
	
    }
}
