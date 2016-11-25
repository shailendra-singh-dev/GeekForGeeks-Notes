package data_structures;

public class TreeNode {

    private Object mData;
    public TreeNode mLeftNode;
    public TreeNode mRightNode;
    private int mIntData;
    
    public TreeNode(Object data){
	mData = data;
    }
    
    public TreeNode(int data){
	mIntData = data;
    }
    
    

    public int getIntData() {
        return mIntData;
    }

    public void setIntData(int mIntData) {
        this.mIntData = mIntData;
    }

    public Object getData() {
        return mData;
    }

    public TreeNode getLeftNode() {
        return mLeftNode;
    }

    public TreeNode getRightNode() {
        return mRightNode;
    }

    public void setData(Object mData) {
        this.mData = mData;
    }

    public void setLeftNode(TreeNode mLeftNode) {
        this.mLeftNode = mLeftNode;
    }

    public void setRightNode(TreeNode mRightNode) {
        this.mRightNode = mRightNode;
    }
    
    @Override
    public String toString() {
      return "["+getIntData()+"]";
    }
    
    
}
