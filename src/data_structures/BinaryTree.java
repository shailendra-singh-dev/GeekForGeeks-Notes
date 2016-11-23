package data_structures;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {

    private TreeNode mRootNode;

    public BinaryTree() {
	mRootNode = null;
    }

    public BinaryTree(final Object data) {
	mRootNode = new TreeNode(data);
    }

    public void setRootNode(final TreeNode node) {
	mRootNode = node;
    }

    public TreeNode getRootNode() {
	return mRootNode;
    }
    
    
    public void constructTree() {
	TreeNode rootNode = new TreeNode(1);
	setRootNode(rootNode);

	TreeNode node2 = new TreeNode(2);
	TreeNode node3 = new TreeNode(3);

	rootNode.setLeftNode(node2);
	rootNode.setRightNode(node3);

	TreeNode node4 = new TreeNode(4);
	TreeNode node5 = new TreeNode(5);

	node2.setLeftNode(node4);
	node2.setRightNode(node5);

	TreeNode node6 = new TreeNode(6);
	TreeNode node7 = new TreeNode(7);

	node3.setLeftNode(node6);
	node3.setRightNode(node7);

    }

    public void printTree() {
	constructTree();
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	queue.offer(getRootNode());
	
	int count = 0;
	while (!queue.isEmpty()) {
	    TreeNode node = queue.poll();
	    if(null == node){
		return ;
	    }
	    System.out.println(node);
	    if (node.getLeftNode() != null) {
		queue.offer(node.getLeftNode());
	    } 
	    if(node.getRightNode() != null) {
		queue.offer(node.getRightNode());
	    }
	    
	    count++;
	}
    }
    
}
