package main;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

import math.MaxPointsInLine;

import data_structures.BinarySearchTree;
import data_structures.BinaryTree;

import arrays.EquilibriumIndex;
import arrays.SelectionSort;
import arrays.StringToInt;

public class AlgorithmsMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] array = new int[] { 1, 3, 5, 2, 2 };
	int index= EquilibriumIndex.getEquilibriumIndex(array);
	System.out.print("index:"+index);	
    }
}
