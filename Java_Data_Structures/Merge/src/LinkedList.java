import java.util.Random;

public class LinkedList {
	private Node root = null;
	
	private Node tail = null;
	private int size = 0;
	
	//set/get root/tail
	public Node getRoot(){
		return this.root;
	}
	public Node getTail(){
		return this.tail;
	}
	private void setRoot(Node newRoot){
		this.root = newRoot;
		root.setPrev(tail);
		
		
	}
	private void setTail(Node newTail){
		this.tail = newTail;
		tail.setNext(root);
	}
	//adds to linked list to help implement randBuild
	public void add(Node newNode){
		
		if (root == null){
			setRoot(newNode);
			setTail(newNode);
			size ++;
			
		}
		else{
			Node temp = this.root;
			while(temp.getNext() != root){
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			newNode.setPrev(temp);
			setTail(newNode);
			size ++;	
			
		}
	}
	//randomly builds a doubly linked list
	public LinkedList randBuild(int i){
		int listLength = i;
		
			
		LinkedList out = new LinkedList();
		Random rand = new Random();
		while(listLength>=out.size){
			
			out.add(new Node(rand.nextInt(10000)));
		}
		return out;
		
	}
	//swaps two nodes regardless of position in linked list
	public void swap(Node before, Node after){
		
		if(before == this.root){
			
			
			before.setNext(after.getNext());
			after.getNext().setPrev(before);
			before.setPrev(after);
			after.setNext(before);
			setRoot(after);
			setTail(tail);
			
			
		
		}
		else if(after == this.tail){
			after.setPrev(before.getPrev());
			before.getPrev().setNext(after);
			after.setNext(before);
			before.setPrev(after);
			setTail(before);
			setRoot(root);
			
		}
		else{
			
			before.getPrev().setNext(after);
			after.setPrev(before.getPrev());
			before.setNext(after.getNext());
			after.getNext().setPrev(before);
			after.setNext(before);
			before.setPrev(after);
		
		}
		
	}
	
	
	//implements a bubble sort with swap and isSorted
	public LinkedList bubbleSort(){
		while(this.isSorted() == false){
			Node curr = this.root;
			Node next = curr.getNext();
			while(next.getNext() != root){
		
				if(next.getValue( ) < curr.getValue()){
					swap(curr, next);
					curr = next;
					next = curr.getNext();
			
				}
				else{
					curr = curr.getNext();
					next = next.getNext();
				}
			}
		//System.out.println("pass..");
		//this.printForword();
		}
		return this;
	
	
	}
	//returns if the list is sorted
	public boolean isSorted(){
		boolean sort = true;
		Node curr = this.root;
		Node next = curr.getNext();
		while(next.getNext() != root){
			if(next.getValue( ) < curr.getValue()){
				sort = false;
				curr = curr.getNext();
				next = next.getNext();
			}
			else{
				curr = curr.getNext();
				next = next.getNext();
			}
		}
		
		return sort;
		
	}
	
	public void printForword(){
			Node tmp = root;
			System.out.println("Forward Print List Size("+ this.size +")");
		    while (tmp.getNext() != root ) {
		    		
		    		
		        System.out.println(tmp.print());
		        tmp = tmp.getNext();
		        
		    }
	}
	public void destroy(){
			this.root.setNext(null);
			this.tail.setPrev(null);
		}
	
	public LinkedList mergeSort(){
		
	}
	
	//end
}
	 
		
	
	

