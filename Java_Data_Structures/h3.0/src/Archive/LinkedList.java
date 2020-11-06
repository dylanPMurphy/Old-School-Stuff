
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
		
	}
	private void setTail(Node newTail){
		this.tail = newTail;
	}
	public void addToBegining(Node rt){
		Node temp0 = getRoot();
		setRoot(rt);
		getRoot().setNext(temp0);
		temp0.setPrev(getRoot());
		
		size ++;
		
		
	}
	public void insertNodeABC(Node newNode){
		
		if (root == null){
			setRoot(newNode);
			setTail(newNode);
			size ++;
			System.out.println("added at root" + newNode.getData());
		}
		else if(root != null && root.getNext() == null){
			if (root.getData().compareTo(newNode.getData()) > 0 ){
				//this is if newNode goes before root
				addToBegining(newNode);
				setTail(root.getNext());
				System.out.println("added" + newNode.getData() + "after root");
			}
			else{
				//this is if newNode goes after root
				getRoot().setNext(newNode);
				newNode.setPrev(getRoot());
				
				setTail(newNode);
				size ++;
				System.out.println("added  after root" + newNode.getData());
			}
		}
		else if(root.getData().compareTo(newNode.getData()) > 0 ){
			addToBegining(newNode);
			
			System.out.println("added to begining" + newNode.getData());
			size++;
		}
		else{
		    //BUG:NULL POINTER
			Node temp1 = root;
			System.out.println("uhmmm hello");

			while(temp1.getData().compareTo(newNode.getData()) > 0 || temp1.getNext() != null){
			
				temp1 = temp1.getNext();
				
				
				}
			System.out.println("...");
			
			if(temp1 != tail){
		    System.out.println("....");
		    if(temp1.getPrev()!= null){
		
			newNode.setNext(temp1);
			newNode.setPrev(temp1.getPrev()); 
			temp1.getPrev().setNext(newNode);
			temp1.setPrev(newNode);
			size ++;
			System.out.println("added in the middle" + newNode.getData());
		    }
			}
			else{
				getTail().setNext(newNode);
				newNode.setPrev(getTail());
				setTail(newNode);
				System.out.println("added at tail"  + newNode.getData());	
			}
		}
		
		}

		public Node find(String s){
			Node temp1 = root;
			

			while(temp1.getData().compareTo(s) != 0){
				temp1 = temp1.getNext();
			}
			return temp1;
		}
		         
		public void	printBackward(){
			Node tmp = tail;
		    while (tmp != null) {
		        tmp.print();
		        tmp = tmp.getPrev();
		}
		}
		
		public void printForword(){
			Node tmp = root;
		    while (tmp != null) {
		        tmp.print();
		        tmp = tmp.getNext();
		}
		}
		public void destroy(){
			this.root.setNext(null);
			this.tail.setPrev(null);
		}
	}
	 
		
	
	

