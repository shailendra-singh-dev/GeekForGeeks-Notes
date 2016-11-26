package main;

import java.util.Arrays;

import data_structures.BinarySearchTree;
import data_structures.BinaryTree;

import arrays.SelectionSort;

public class AlgorithmsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.constructTree();
		binarySearchTree.inorderTraversal(binarySearchTree.getRootNode());
	}
}
