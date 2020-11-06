
public class Stack {
	protected Node top;
	private int size=0;
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return this.top==null;
	}
	public Node peek(){
		return this.top;
	}
	public void push(Node N){
		if(this.isEmpty()){
			this.top = N;
			size++;
			}
		else{
			//System.out.println("pushing to top");
			Node temp = this.top	;
			this.top = N;
			top.setNext(temp);
			size++;
		}
	}
	public Node pop(){
		if(this.isEmpty()){
			
			//System.out.println("The stack is empty");
			return null;
		}
		else{
			//System.out.println("...Raindrop top pop");
			Node temp = this.top;
			top = top.getNext();
			size--;
			return temp;
		}
		
	}
	public void print(){//prints and demonstrates Stack
		Node temp1 = this.top;
		System.out.println("This stack has a size of:"+size);
		System.out.println();
		for(int i = this.size; i>0;i--){
			
			System.out.println(temp1.print());
			
			temp1 = temp1.getNext();
			
			System.out.println("---------------------");
			
		}
		
	}

}
