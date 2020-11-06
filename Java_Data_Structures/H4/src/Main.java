/*
 * Dylan Murphy
 * HW4 Stacks and Queues
 * 
 * This code is meant to demonstrate the relationships between Stacks
 * and Queues.  
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("THE FIVE BASIC PRINCIPLES OF LIBERTY");
		
		//V Initial Stack config
		Stack stck = new Stack();
		String[] a = {"Limited Government", "Individualism", 
					  "Peace", "Tolerance", "Free Markets"};
		for(int i=4;i>=0;i--){
			stck.push(new Node(a[i]));
		}
		stck.print();
		System.out.println();
		
		//V Takes a Stack and returns a Stack that is of equal value
		Stack stck1 = stackToStack(stck);
		stck1.print();
		System.out.println();
		
		//V Takes a Stack and converts it in order into a Queue that is returned
		Queue q = stackToQueue(stck1);
		q.print();
		System.out.println();
		
		//V Takes a Queue and creates a new Stack that is in the same order
		Stack newStack = queueToStack(q);
		newStack.print(); 
		System.out.println();

	}
	
	public static Queue stackToQueue(Stack source){
		Queue newQ = new Queue();
		System.out.println("Stack to queue ...");
		while(source.getSize()>0){
			
			newQ.enqueue(source.pop());
			
		}
		return newQ;
		
	}
	public static Stack queueToStack(Queue source){
		Stack newStack = new Stack();
		System.out.println("Queue to Stack...");
		Stack temp = new Stack();//first temp stack in backwards order
		
		while(source.getSize()>0){
			temp.push(source.dequeue());
		}
		Queue temp1 = new Queue();//second temp stack that is in correct order
		while(temp.getSize()>0){
			temp1.enqueue(temp.pop());
		}
		//temp1.print();
		while(temp1.getSize()>0){
			newStack.push(temp1.dequeue());
		}
		
		return newStack;
		
	}
	public static Stack stackToStack(Stack source){
		System.out.println("Stack to Stack...");
		Stack newStack = new Stack();
		Stack temp = new Stack();
		while(source.getSize() != 0){
			temp.push(source.pop());
		}
		while(temp.getSize() != 0){
		newStack.push(temp.pop());
		}
		
		return newStack;
	}

}
