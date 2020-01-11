package data_structures;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int data;
    
    public TreeNode(int data){
	   this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int mIntData) {
        this.data = mIntData;
    }

    public TreeNode getLeftNode() {
        return left;
    }

    public TreeNode getRightNode() {
        return right;
    }

    public void setLeftNode(TreeNode mLeftNode) {
        this.left = mLeftNode;
    }

    public void setRightNode(TreeNode mRightNode) {
        this.right = mRightNode;
    }
    
    @Override
    public String toString() {
      return "["+getData()+"]";
    }
    
    
    @Override
    public boolean equals(Object obj) {
    	TreeNode treeNode = (TreeNode) obj;
    	return data == treeNode.data; 
    }
    
    
}
