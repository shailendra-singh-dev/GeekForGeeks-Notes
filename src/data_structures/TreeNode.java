package data_structures;

public class TreeNode {

    public TreeNode mLeftNode;
    public TreeNode mRightNode;
    private int mData;
    
    public TreeNode(int data){
	mData = data;
    }

    public int getData() {
        return mData;
    }

    public void setData(int mIntData) {
        this.mData = mIntData;
    }

    public TreeNode getLeftNode() {
        return mLeftNode;
    }

    public TreeNode getRightNode() {
        return mRightNode;
    }

    public void setLeftNode(TreeNode mLeftNode) {
        this.mLeftNode = mLeftNode;
    }

    public void setRightNode(TreeNode mRightNode) {
        this.mRightNode = mRightNode;
    }
    
    @Override
    public String toString() {
      return "["+getData()+"]";
    }
    
    
}
