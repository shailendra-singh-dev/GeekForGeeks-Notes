package main;

import java.util.Arrays;

import javax.sound.sampled.ReverbType;

import arrays.BinarySearch;
import arrays.BubbleSort;
import arrays.LinkedList;
import arrays.Node;
import arrays.PrimeNumbers;
import arrays.QuickSort;
import arrays.Stack;
import arrays.StringReverse;
import arrays.SumOfDigits;

public class AlgorithmsMain {

<<<<<<< HEAD
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
=======
    /**
     * @param args
     */
    public static void main(String[] args) {
	// int[] array = new int[] { 30, 6, -2, 0, 9, 10 };
	// QuickSort.quickSort(array, 0, array.length - 1);
	// BubbleSort.bubbleSort(array);
	// System.out.print("quickSort :" + Arrays.toString(array));

	Node node1 = new Node(1);
	Node node2 = new Node(2);
	Node node3 = new Node(3);
	 LinkedList linkedList = new LinkedList();
//	java.util.LinkedList<Node> linkedList = new java.util.LinkedList<>();

//	linkedList.add(0, node1);
//	linkedList.add(1, node2);
//	linkedList.add(2, node3);
	
	linkedList.add(node1);
	linkedList.add(node2);
	linkedList.add(node3);
	System.out.println("linkedList :" + linkedList);
	
	linkedList.remove(2);
	System.out.println("linkedList :" + linkedList);
	
	System.out.println("linkedList.get(1): " + linkedList.get(1));
>>>>>>> 92c09620d603e965e6a9a22dd0d7555c4080e05a
    }
    System.out.print("array :" + Arrays.toString(array));

  }
}
