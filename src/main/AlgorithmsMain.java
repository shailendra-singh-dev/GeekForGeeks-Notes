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


    int[] array = new int[] {1, 2, 3, 4, 5};
    System.out.print("array :" + Arrays.toString(array));
    int d = 4;
    for (int i = 0; i < d && i < array.length-1; i++) {
      array[i] = array[i + 1];
      array[array.length - 1] = array[i];
      array[array.length - i - 1] = array[array.length - 1];
    }
    System.out.print("array :" + Arrays.toString(array));

  }
}
