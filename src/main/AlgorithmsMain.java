package main;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

import math.MaxPointsInLine;

import data_structures.BinarySearchTree;
import data_structures.BinaryTree;
import data_structures.TreeNode;

import arrays.EquilibriumIndex;
import arrays.SelectionSort;
import arrays.StringToInt;

public class AlgorithmsMain {
	public static void main(String[] args) {
		int[] array = new int[] { -7, 1, 5, 2, -4, 3, 0 };
		int index = EquilibriumIndex.getEquilibriumIndexEfficient(array);
		System.out.print("index:" + index);
	}
}
