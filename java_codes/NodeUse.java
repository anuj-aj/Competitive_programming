package data_structures;
import java.util.Scanner;

public class NodeUse  {

	//taking input
	public static Node <Integer> takeinput(){
		Scanner s = new Scanner(System.in);
		int data =s.nextInt();
		Node <Integer > head = null;
		Node <Integer > tail;
		while (data!=-1) {
		Node <Integer > nodestart =new Node<>(data);
		if(head==null) {
			head = nodestart; 
		}
		
		else {
			Node <Integer> temp =head; 
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=nodestart;
			
		}
		data=s.nextInt();
		}
		
		return head;
		
		
	}
		
	

	//taking input (optimised)
	public static Node <Integer> takeinput2(){
		Scanner s = new Scanner(System.in);
		int data =s.nextInt();
		Node <Integer > head = null;
		Node <Integer > tail= null;
		while (data!=-1) {
		Node <Integer > nodestart =new Node<>(data);
		if(head==null) {
			head = nodestart; 
			tail = nodestart; 
			
		}
		
		else {
			tail.next=nodestart;
			tail=tail.next;
		}
		data=s.nextInt();
		}
		
		return head;
		
		
	}

	//printing linked list
	public static void print(Node <Integer> head) {
while(head != null) {
			
			System.out.print( head.data + " ");
			head = head.next;
		}
System.out.println();
	}
	
	





	//insertion
	public static void insert(Node<Integer> head, int data,int pos){
	    Node<Integer> start= head;
	    
	    for(int j=0;j<pos-1;j++){
	        
	        start=start.next;
	    }
	    Node <Integer> oldn=start.next;
	    Node <Integer> n =new Node(data);
	    start.next=n;
	    n.next=oldn;
	    
	}
	
	
	//printIth
	
	public static void printIth(Node<Integer> head, int i){
	    Node<Integer> start= head;
	    
	    for(int j=0;j<i;j++){
	        if(start.next==null){
	        return;
	    }
	        start=start.next;
	    }
	     System.out.println(start.data);
	
	    
	    
	}
	
	
	public static void main(String[] args) {
		Node<Integer> head=takeinput2();
		print(head);
		print(head);


	}

}


