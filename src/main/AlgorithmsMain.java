package main;

import java.util.Arrays;
import java.util.LinkedList;

import data_structures.BinarySearchTree;
import data_structures.BinaryTree;

import arrays.SelectionSort;

public class AlgorithmsMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	
	BinarySearchTree binarySearchTree=new BinarySearchTree();
	binarySearchTree.constructTreee();
	binarySearchTree.inOrderTraversal(binarySearchTree.getRootNode());
    }
}
