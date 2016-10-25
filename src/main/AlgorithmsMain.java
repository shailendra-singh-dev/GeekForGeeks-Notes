package main;

import javax.sound.sampled.ReverbType;

import arrays.PrimeNumbers;
import arrays.Stack;
import arrays.StringReverse;
import arrays.SumOfDigits;

public class AlgorithmsMain {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>(5);
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);
    System.out.println("pop:" + stack.pop());
    System.out.println("peek:" + stack.peek());
    stack.push(60);
    System.out.println(stack.toString());
  }


}
