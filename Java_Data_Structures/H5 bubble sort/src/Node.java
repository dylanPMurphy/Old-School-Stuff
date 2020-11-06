
public class Node {
	private int value;
	private Node next;
	private Node prev;
	
	public Node(int a){
		this.value = a; 
	}
	public Node getNext(){
		return this.next;
	}
	public Node getPrev(){
		return this.prev;
	}
	public void setPrev(Node N){
		this.prev = N;
	}
	public void setNext(Node N){
		this.next = N;
	}
	public void setValue(int i){
		this.value = i;
	}
	public int getValue(){
		return this.value;
	}
	public int print(){
		return this.value;
	}
	

}
