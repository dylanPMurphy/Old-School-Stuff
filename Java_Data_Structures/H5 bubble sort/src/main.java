
public class main {

	public static void main(String[] args) {
		int[] a = {21,2,43,5,6,7,4,1,2,4,6,6,0,1,1,1,1,1,1,100,2,2,1,1,1,1,0,0,0,0};
		LinkedList ll = new LinkedList();
		/*for(int i=0;i<a.length;i++){
			ll.add(new Node(a[i]));
		}
		//System.out.println("isSorted test:"+ll.isSorted());
		ll.printForword();
		System.out.println("---------------------");
		//ll.swap(ll.getRoot().getNext(), ll.getRoot().getNext().getNext());
		ll.printForword();
		//System.out.println("isSorted test:"+ll.isSorted());
		System.out.println("---------------------");
		
		System.out.println("---------------------");
		ll = ll.sort();
		ll.printForword();
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		System.out.println("*************************");
		
		*/
		
		ll = ll.randBuild(15);
		ll.printForword();
		
		ll = ll.bubbleSort();
		ll.printForword(); 
		
		System.out.println("*************************");
		System.out.println("*************************");
		
		
		
		
		
		
		
		
		}
		
		
	
		

}

