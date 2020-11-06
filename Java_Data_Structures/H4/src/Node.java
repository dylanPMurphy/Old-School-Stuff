
public class Node {
	private String name;
	private Node next;
	
	public Node(String s){
		this.name = s; 
	}
	public Node getNext(){
		return this.next;
	}
	public void setNext(Node N){
		this.next = N;
	}
	public String getName(){
		return this.name;
	}
	public String print(){
		return this.name;
	}
}
