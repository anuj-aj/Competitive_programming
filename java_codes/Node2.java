package data_structures;
import java.util.Scanner;
public class Node2 {
	
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
		
		





		//insertion  change the return type
		public static void insert(Node<Integer> head, int data,int pos){
		    if(pos==0) {
		    	Node <Integer> n =new Node(data);
		    	n.next=head;
		    	head=n;
		    }
			
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
		
		//merge 2 sorted LL
		public static Node<Integer> mergeTwoList(Node<Integer> head1, Node<Integer> head2) {
			Node<Integer> t1 =head1;
			Node<Integer> t2 =head2;
			Node<Integer> h3;
			Node<Integer> t3;
			
			if(head1.data>=head2.data) {
				h3=t2;
				t3=t2;
				t2=t2.next;
			}
			else {	h3=t1;
			        t3=t1;
			        t1=t1.next;
				
			}
			
			while(t1!=null&&t2!=null) {
				if(t1.data>=t2.data) {
					t3.next=t2;
					t3=t2;
					t2=t2.next;
				}
				else {
				 	 t3.next=t1;
				     t3=t1;
				     t1=t1.next;
				}
				
				
				
			}

			if(t1==null) {
				t3.next=t2;
				t3=t2;
				t2=t2.next;
			}
			else {
			 	 t3.next=t1;
			     t3=t1;
			     t1=t1.next;
			}
			
			
			
			
			return h3;
			
			
		}

		// Merge Sort
		public static Node<Integer> mergeSort(Node<Integer> head) {

			if(head.next==null) {
				return head;
			}
			
			Node <Integer> starta =head;
			Node<Integer> mid=printMiddel(head);
			Node <Integer> midnext =mid.next;
			mid.next=null;
			Node <Integer> head1 =mergeSort(starta);
			Node <Integer> head2=mergeSort(midnext);
			Node <Integer> h=mergeTwoList(head1,head2);
			return h;
			
			
		}
		
		
		
		
		public static Node<Integer>  printMiddel(Node<Integer> head) {
			if (head == null) { 
				return null; } 
			Node<Integer> slow_ptr = head; 
			Node<Integer> fast_ptr = head.next;
			while (fast_ptr != null && fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next; 
				slow_ptr = slow_ptr.next; 
				} 
			return slow_ptr;
			}
                                                                                                                                                                                                                                                                               
		
		
		
		
		
		
		//recursive reverse
		
		public static Node<Integer> reverse_R(Node<Integer> head) {
			if(head.next==null||head==null) {
				return head;
			}
			Node<Integer> finalhead= reverse_R(head.next);
			Node<Integer> revdone=finalhead;
			while(revdone.next!=null) {
				revdone=revdone.next;
			}
			revdone.next=head;
			head.next=null;
			return finalhead;
		}
		
		
		
		
		
		
		//recursive reverse better
		public static doubleNode reverse_Rbet(Node<Integer> head) {
			if(head.next==null||head==null) {
				doubleNode ans= new doubleNode();
				ans.head=head;
				ans.tail=head;
				return ans ;
			}
			doubleNode smallans= reverse_Rbet(head.next);
			smallans.tail.next=head;
			head.next=null;
			
			doubleNode ansa = new doubleNode();
			ansa.head=smallans.head;
			ansa.tail=head;
			return ansa;
		}

		
		
		
		
		
		
		//best recursive reverse 
  
		public static Node<Integer> reverseb(Node<Integer> head) {
			if(head.next==null||head==null) {
				return head;
			}
			Node<Integer> reversedtail =head.next;
			
			Node<Integer> finalhead= reverseb(head.next);
			reversedtail.next=head;
			head.next =null;
			return finalhead;
		}
	     
		

		
		
		
		
		//insert recursive  
		public static Node<Integer> insertr(Node<Integer> head,int pos,int elem) {
			if(pos==0) {
				
			Node<Integer>	n = new Node<>(elem);
			n.next=head;
			return head;
			}
			head.next =  insertr(head.next,pos-1,elem);
			return head;
			
			}
		
		
		
		
		
		//index of n recursively
		public static int indexOfNRec(Node<Integer> head, int n,int pos) {
			if(head==null) {
				return -1;
			}
			if(head.data==n) {
				return pos;
			}
			int x = indexOfNRec(head.next, n,pos+1);
			return x;
			
		}
	
		
		
		
		
		
		
		//sort even
		public static Node<Integer> sortEven(Node<Integer> head) {
		    
		    if(head==null){
		        return head;
		    }
		    
		    Node<Integer> smallans= sortEven(head.next);
		    Node<Integer> temp=smallans ;
		    if(head.data%2==0){
		    	temp =head;
		        temp.next = smallans;
		        return temp;
		    }
		    else {
		    	return temp;
		    }

		}
		
		
		
		
		
		//sort odd

		public static Node<Integer> sortOdd(Node<Integer> head) {
		    
		    if(head==null){
		        return head;
		    }
		    
		    Node<Integer> smallans= sortOdd(head.next);
		    Node<Integer> temp=smallans ;
		    if(head.data%2!=0){
		    	temp =head;
		        temp.next = smallans;
		        return temp;
		    }
		    else {
		    	return temp;
		    }

		}

		// sort even odd
		public static Node<Integer> sortEvenOdd(Node<Integer> head) {
			  Node<Integer>current=head;
				Node<Integer>evenHead=null;
				Node<Integer>oddHead=null;
				Node<Integer>evenTail=null;
			    Node<Integer>oddTail=null;
				while(current!=null)
				{
					if(current.data%2==0)
					{
						if(evenHead==null)
						{
							evenHead=evenTail=current;
						}
						else
						{
							evenTail.next=current;
							evenTail=current;
						}
					}
					else
					{
						if(oddHead==null)
						{
							oddHead=oddTail=current;
						}
						else
						{
							oddTail.next=current;
							oddTail=current;
						}
					}
					current=current.next;
				}
				oddTail.next=evenHead;
				evenTail.next=null;
				return oddHead;
		}
		
		
		

		
		// skipMdeleteN           
		
		public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		    if(M==0){
		        return null;
		    }
		    if(N==0){
		        return head;
		    }
			Node<Integer> curr = head ;
			while (curr!=null) {
			int n=0,m=0;
			while(m<M-1&&curr!=null){
			    curr=curr.next;
			    if(curr==null||curr.next==null){
			        return head;
			    }
			    m++;
			}
			Node<Integer> temp =curr.next;
			while(n<N&&temp!=null){
			    temp=temp.next;
			    if(temp==null){
			        curr.next=null;
			        return head;
			    }
			    n++;
			}
			curr.next=temp;
			curr=temp;
			
			}
		    return head;

		}
	
		
		
		
		
		//Swap Nodes
		public static Node<Integer> swap_nodes(Node<Integer> head,int i,int j) { 
			Node<Integer> temp = head,
					prev = null;
			Node<Integer> node1 = null, 
					node2 = null, 
					node1_prev = null, node2_prev = null; 
			int pos = 0; 
			while(temp != null) { 
				if(pos == i) {
					node1_prev = prev; node1 = temp; } 
				else if(pos == j) { 
					node2_prev = prev; node2 = temp; } 
				prev = temp;
				temp = temp.next;
				pos++; } 
			if(node1_prev != null) { 
				node1_prev.next = node2; }
			else { 
				head = node2; } 
			if(node2_prev != null) { 
				node2_prev.next = node1; } 
			else {
				head = node1; } 
			Node<Integer> temp1 = node2.next;
			node2.next = node1.next;
			node1.next = temp1; 
			return head; 
		}

		
		
		
		// My fun swap nodes
		public static  Node<Integer> myswap_nodes(Node<Integer> head,int i,int j){
		    
		    int ii =Math.min(i,j);
		    
		    int jj =Math.max(i,j);
		        int ia=0,ja=0;

		    Node<Integer> curr =head;
			int n=0;
			 Node<Integer> nhead=null ;
			    if(ii==0&&jj==1) {
			  
			    nhead =curr.next;
			 Node<Integer> nheadnext =curr.next.next;
			    nhead.next=head;
			  
			    head.next=nheadnext;
			    return nhead;

			    }
			    else if(ii==0&&jj!=1) {
			    while(ja<jj-1) {
			    	curr=curr.next;
			    	ja++;
			    }
			    nhead =curr.next;
			 Node<Integer> nheadnext =curr.next.next;
			 Node<Integer> temp =head.next;
			    nhead.next=temp;
			    curr.next=head;
			    head.next=nheadnext;
			    return nhead;

			    }
			
			for(;n<ii-1;n++){
			    curr=curr.next;
			}
			
			
			if(jj-1==ii){
		        

			Node<Integer> p1 =curr;
			Node<Integer> f1=curr.next;
			Node<Integer> f1next =curr.next.next;
			
			Node<Integer> f1nextnext =curr.next.next.next;
		        curr.next=f1next;
		        f1next.next=f1;
		        f1.next=f1nextnext;
		        return head;
		    }

			Node<Integer> p1 =curr;
			Node<Integer> f1=curr.next;
			Node<Integer> f1next =curr.next.next;
			while(n<jj-1){
			    curr=curr.next;
			    n++;
			}
			Node<Integer> f2 =curr.next;
			Node<Integer> f2next =curr.next.next;
			p1.next = f2;
			f2.next=f1next;
			curr.next= f1;
			f1.next=f2next;
			
			
				
		
		return head;
		    
		}
		
		
		
		
		
		//Bubble Sort
		public static Node<Integer> bubbleSort(Node<Integer> head )
		{
			Node<Integer> n= head;
			Node<Integer> curr= head;
			int count =0;
			while(curr.next!=null) {
				count++;
				curr=curr.next;
			}
			curr= head;
			int i=0;
			while(i<count) {
				int j=0;
				while(curr.next!=null) {
					
					if(curr.data>curr.next.data) {
						n=swap_nodes(n, j+1, j);
						j++;
					}
					else {curr=curr.next;
					j++;}
					
				}
				curr=n;
				i++;
			}
			
			return n;
		}


		
		
		
	public static void main(String[] args) {
		Node<Integer> head1=takeinput2();

	
		
		print(head1 );
		
}}



class doubleNode {
	Node<Integer> head;
	Node<Integer> tail;
	
}

