/**
 *
 * @author zumrut
 */
public class BST {

     private BSTNode root;
 
     public BST()
     {
         root = null;
     }

     public boolean isEmpty()
     {
         return root == null;
     }
     
     public void setRoot(int data){
         root = new BSTNode(data);
     }
     
     public BSTNode getRoot(){
         return root;
     }
 
     public void insert(int data)
     {
        insert(root, data);
     }

     private void insert(BSTNode node, int data)
     {
        if(data <= node.getData()){
          if(node.getLeft() != null){
           insert(node.getLeft(), data); 
          }
          else{
           BSTNode newNode = new BSTNode(data);
           node.setLeft(newNode);
          }
        }
        else{
          if(node.getRight() != null){
           insert(node.getRight(), data); 
          }
          else{
           BSTNode newNode = new BSTNode(data);
           node.setRight(newNode);
          }
        }
     }
     

     public void inorder()
     {
         inorder(root);
     }
     private void inorder(BSTNode r){
         if(r != null){
          inorder(r.getLeft());
          System.out.println(r.getData());
          inorder(r.getRight());
        }
     } 

     
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST bstInstance = new BST();  
        bstInstance.setRoot(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root data " + bstInstance.getRoot().getData());
        bstInstance.insert(1);
        bstInstance.insert(8);
        bstInstance.insert(6);
        bstInstance.insert(3);
        bstInstance.insert(9);
        System.out.println("Traversing tree in order");
        bstInstance.inorder();
        System.out.println();
    }
    
}
