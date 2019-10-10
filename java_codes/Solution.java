package data_structures;

import java.util.Scanner;
public class Solution {


	//printing linked list
	public static void print(Node <Integer> head) {
	
while(head != null) {
			
			System.out.print( head.data + " ");
			head = head.next;
		}
System.out.println();
	}
	
	

	//taking input
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

	

	//insertion
	public static Node<Integer> insert(Node<Integer> head, int data,int pos){
	   
	    if(pos==0) {
	    	Node <Integer> n =new Node(data);
	    	  n.next=head;
	    	  head=n;
			    return head;
		    	    
	    }
	    else { Node<Integer> start= head;
	    for(int j=0;j<pos-1;j++){
	        
	        start=start.next;
	    }
	    Node <Integer> oldn=start.next;
	    Node <Integer> n =new Node(data);
	    start.next=n;
	    n.next=oldn;
	    return head;
	    }}

	
	
	
	
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
	
	
	
	
	//delete node
	

	public static Node<Integer> deleteIthNode(Node<Integer> head, int pos){
		Node<Integer> start = head;

		if(pos==0) {
			
			head=start.next;
			return head;
		}
		
		
		for(int j=0;j<pos-1;j++) {
			
			if(start.next==null) {
				return head;
			}
			start=start.next;
			
		}
		if(start.next==null) {
			return head;
		}
		start.next=	start.next.next;
		return head;
	}
	
	public static int indexOfNIter(Node<Integer> head, int n) {
		Node<Integer> start = head;
		int i=0;
		if(start.data==n) {
			return 0;
		}
		
		while(start.next!=null) {
			if(start.data==n) {
				return i;
			}
			start=start.next;
			i++;
			}

		if(start.data==n) {
			return i;
		}
		else {
		
		return -1;
		}
		
	}

	
	
	
	
	//append last n
	
	public static Node<Integer> append(Node<Integer> root, int n) {
		int x=length(root);
		int y= x-n;
		Node<Integer> head =root;
		Node<Integer> start =root;
		
		while(start.next!=null) {
			start=start.next;
		}
		start.next=root;
		Node<Integer> mystart =head;
			int i=1;
			while (i<y) {
				mystart=mystart.next;
				i++;
			}
			head=mystart.next;
			mystart.next=null;
			return head;
	}
	
	
	
	
	
//remove duplicates
	public static Node removeDuplicates(Node head) {
		Node start =head;
		while(start.next!=null) {
			if(start.data==start.next.data) {
				start.next=start.next.next;
				if(start.next==null) {
					return head;
				}
				
			}
			
			else{start=start.next;}
		}
		
		return head;
		
	}
	
	
	
	
	
	
	public static void printReverseRecursive(Node<Integer> root) {
	    if(root.next==null){
	       System.out.print(root.data+" "); 
	       return;
	    }
	    printReverseRecursive(root.next);
	    System.out.print(root.data+" ");
	    
	}
	
	
	
	
	
	
	//length of LL
	public static int length(Node<Integer> head){
	Node<Integer> start =head;
	if(head==null) {
		return 0;
	}
		int count=1;
		while(start.next!=null) {
			count++;
			start=start.next;
		}
		return count;
		
	}
	
	
	
	//is Palindrome
	public static boolean isPalindrome_2(Node<Integer> head) {
		int x = length(head);
		Node<Integer> start =head;
		Node<Integer> starta =head;
		
		 
			int i=1;
			while(i<(x/2)) {
				start = start.next;
				i++;
			}
			
			Node<Integer> endstart =start;
			Node<Integer> end;
			if(x%2==0) {end =reverse(start.next);}
			else { end =reverse(start.next.next);}
			endstart.next=null;
			 i=1;
			
				while(starta.data.equals(end.data)) {
					
					if(starta.next==null&&end.next==null) {
						return true;
					}
					starta=starta.next;
					end=end.next;
				}
				
				

				
				
				
			
			
			return false;
	}
	

	
	//reverse
	
		public static Node<Integer>  reverse(Node<Integer> head) {
			Node<Integer> curr =head;
			Node<Integer> prev =null;
			Node<Integer> temp;
			while(curr!=null) {
				temp =curr.next;
				curr.next = prev;
				prev = curr;
				curr=temp;
				}
				
			
			return prev;
			
		}
		
		

		
		public static int printMiddel(Node<Integer> head) {
		    Node<Integer> slow = head;
		    Node<Integer> fast = head;
		    while(fast.next!=null){
		        slow=slow.next;
		        fast=fast.next.next;
		        if(fast.next==null) {
		        	return slow.data;
		        }
		        else if(fast.next.next==null){
		            return slow.data;
		        }
		    }
		     return slow.data;
		    
		    
		}
		
		
		

		//insert recursive  
		public static Node<Integer> insertr(Node<Integer> head,int pos,int elem) {
			if(pos==0) {
				
			Node<Integer>	n = new Node<>(elem);
			n.next=head;
			return n;
			}
			head.next =  insertr(head.next,pos-1,elem);
			return head;
			
			}
		
		
	

		
		
		//delete recursive  
		public static Node<Integer> deleteIthNodeRec(Node<Integer> head,int pos) {
			if(pos==0) {
			return head.next;
			}
			if(head.next==null) {
				return head;
				}
			
			head.next =deleteIthNodeRec(head.next,pos-1);
			return head;
			
			}
		

		public static Node<Integer> deleteIthNodeRec1(Node<Integer> head, int i){
			if(head==null) {
				return head;
			}
			
		
			
			Node <Integer > h=deleteIthNodeRec(head,i);
			return h;
		}
	
	//main
		
		
		
		
		
		
		
		
		public static Node<Integer> deleteIthNodeRec3(Node<Integer> head,int pos) {
			if(pos==0) {
			return head.next;
			}
			
			head.next =deleteIthNodeRec3(head.next,pos-1);
			return head;
			
			}
		

		public static Node<Integer> deleteIthNodeRec4(Node<Integer> head, int i){
			if(head==null) {
				return head;
			}
			Node<Integer> n =head;
			int j=0;
			while(n.next!=null){
			    n=n.next;
			    j++;
			
			    
			}
			if(j<i){
			    return head;
			}
			
			Node <Integer > h=deleteIthNodeRec3(head,i);
			return h;
			
		}
	
		
		
		
		
		
		
	public static void main(String[] args) {
		Node<Integer> head=takeinput2();

		Node<Integer>  head1= deleteIthNodeRec1( head,7);
	    print(head1);
	}

	

}
