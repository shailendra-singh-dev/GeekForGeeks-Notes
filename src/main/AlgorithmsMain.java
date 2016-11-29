package main;

import java.util.Arrays;
import java.util.LinkedList;

import data_structures.BinarySearchTree;
import data_structures.BinaryTree;
import data_structures.TreeNode;

import arrays.SelectionSort;

public class AlgorithmsMain {

	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.constructTreee();
		System.out.println("inOrderTraversal:");
		binarySearchTree.inOrderTraversal(binarySearchTree.getRootNode());
		System.out.println("\npreOrderTraversal:");
		binarySearchTree.preOrderTraversal(binarySearchTree.getRootNode());
		System.out.println("\npostOrderTraversal;");
		binarySearchTree.postOrderTraversal(binarySearchTree.getRootNode());
		
		TreeNode treeNode=new TreeNode(60);
		TreeNode rootNode=binarySearchTree.getRootNode();
		System.out.print("\nrootNode:"+rootNode+",treeNode:"+treeNode+"\n");
		treeNode=binarySearchTree.searchItem(rootNode, treeNode);
		System.out.print("searchItem:"+treeNode);
		
	}
}
