package data_structures;

public class TreeNode {

    private Object mData;
    private TreeNode mLeftNode;
    private TreeNode mRightNode;
    
    public TreeNode(Object data){
	mData = data;
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
      return "["+getData()+"]";
    }
    
    
}
