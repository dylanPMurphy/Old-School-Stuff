import java.util.ArrayList;
public class Tree {
	private TNode root;
	ArrayList<String> list = new ArrayList<String>();
	public Tree(){
		root=null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	public void setRoot(String data){
		root = new TNode(data);
	}
	public TNode getRoot(){
		return root;
	}
	
	//Inserts a new tree node into the tree in alpha order with the help of private insert
	public void insert(String s){
		if(root!=null){
            insert(root, s);
        }
		else{
			root = new TNode(s);
		}
	}
	private void insert(TNode t, String s){
		if(s.compareToIgnoreCase(t.getData()) < 0){
			if(t.left != null){
				insert(t.left, s);
			}
			else{
				TNode newNode = new TNode(s);
				t.left = newNode;
				newNode.setParent(t);
			}
		}else  if(s.compareToIgnoreCase(t.getData()) > 0){
			if(t.right != null){
				insert(t.right, s);
			}
			else{
				TNode newNode = new TNode(s);
				t.right = newNode;
				newNode.setParent(t);
			}
		}else{//if the string is in the tree the frequency increases
			t.addFreq();
		}
	}
	
	//prints the Frequency histogram
	public void inorder()
    {
         inorder(root);
    }
    
    private void inorder(TNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.println(r.getData() +" "+r.getFreq());
             list.add(r.getData());
             inorder(r.getRight());
         }
     }
    //finds the node with a matching string
    public TNode find(String target){
    		if(root.getData().compareToIgnoreCase(target) == 0 ){
    			return root;
    		}
    		else if(root.getData().compareToIgnoreCase(target)<0 && root.hasRight()){
    			return find(root.getRight(), target);
    		}
    		else if(root.getData().compareToIgnoreCase(target)>0 && root.hasLeft()){
    			return find(root.getLeft(), target);
    		}
    		else if(root == null){
    			
    			System.out.println("tree is empty");
    			return null;
    		}
    		else{
			return null;
    		}
    }
    private TNode find(TNode t, String s){
    		if(t.getData().compareToIgnoreCase(s)>0 && t.hasLeft()){
    			return find(t.getLeft(), s);
    		}
    		else if(t.getData().compareToIgnoreCase(s)<0 && t.hasRight()){
    			return find(t.getRight(), s);
    		}
    		else{
    			return t;
    		}
    }
    
}
	
	

