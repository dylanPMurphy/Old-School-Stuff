
public class TNode {
	TNode left, right, parent;
    String data;
    int frequency = 1;
    
    public TNode(){
    		parent = null;
    		left = null;
        right = null;
        data = null;
    }
    public TNode(String s){
    		left = null;
        right = null;
        data = s;
    }
    public TNode getParent(){
    	return parent;
    }
    public void setParent(TNode t){
    		this.parent = t;
    }
    
    
    public TNode getLeft(){
    	return left;
    }
    
    public TNode getRight(){
    	return right;
    }
    
    public void setLeft(TNode t)
    {
        left = t;
    }
    public boolean hasLeft(){
    	return this.left != null;
    }
    public boolean hasRight(){
    	return this.right != null;
    }

    public void setRight(TNode t)
    {
        right = t;
    }

    public void setData(String d)
    {
        data = d;
    }

    public String getData()
    {
        return data;
    }
    public void addFreq(){
    	frequency++;
    	
    }
    public int getFreq(){
    	return 	frequency;
    }
}
