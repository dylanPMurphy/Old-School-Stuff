
public class Node {
	
	private String data;
	private Node prev;
	private Node next;
	
	public Node(String data){
		this.prev = null;
		this.data = data;
		this.next = null;
	}
	
	public String getData() {
	    return this.data;
	  }
	  
	  public void setData(String data) {
	    this.data = data;
	  }
	  public Node getPrev(){
		  return this.prev;
	  }
	  public Node getNext(){
		  return this.next;
	  }
	  public void setNext(Node next) {
		    this.next = next;
		  }
	  public void setPrev(Node prev) {
		    this.prev = prev;
		  }
	  public void print(){
		  System.out.println(data);
	  }
	 
	
	
}
