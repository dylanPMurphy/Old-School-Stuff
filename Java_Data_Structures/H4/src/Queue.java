
public class Queue {
	Node front;
	Node back;
	private int size = 0;
	public boolean isEmpty(){
		return this.front==null;
	}
	public int getSize(){
		return size;
	}
	
	
	
	public void enqueue(Node N){
		//System.out.println("...Enqueueing to the back");
		if(this.isEmpty()){
			this.back = N;
			this.front = N;
			size++;
			
			}
		else{
			this.back.setNext(N);
			this.back = N;
			size++;
		}
	}
	public Node dequeue(){
		if(this.isEmpty()){
			
			System.out.println("The queue is empty");
			return null;
		}
		else{
			//System.out.println("Dequeueifying" + this.front.getName());
			Node temp = this.front;
			front = front.getNext();
			size--;
			return temp;
			
		}
		
	}
	public void print(){//prints and demonstrates Queue
		
		Node temp1 = this.front;
		System.out.println("This queue has a size of:"+size);
		for(int i = this.size; i>0;i--){
			System.out.print(temp1.print()+" || ");
			temp1 = temp1.getNext();
		}
		System.out.println();
		
	}
}
