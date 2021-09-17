// Given a Cirular Linked List of size N, split it into two halves circular lists. 
//If there are odd number of nodes in the given circular linked list then out of the resulting two halved lists,
//first list should have one node more than the second list. The resultant lists should also be circular lists and not linear lists.

 

// Example 1:

// Input:
// Circular LinkedList: 1->5->7
// Output:
// 1 5
// 7
 

// Example 2:

// Input:
// Circular LinkedList: 2->6->1->5
// Output:
// 2 6
// 1 5

// Your Task:
// Your task is to complete the given function splitList(), which takes 3 input parameters: The address of the head of the linked list, addresses of the head of the first and second halved resultant lists and Set the head1_ref and head2_ref to the first resultant list and second resultant list respectively.


// Expected Time Complexity: O(N)
// Expected Auxilliary Space: O(1)

// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


public class circular_LinkedList
{
    Node head, head1, head2;  // head of lisl
	//Node last = null;
	Node last = null;
  
    /* Linked list Node*/
   
                    
    /* Utility functions */
 
    /* Inserts a new Node at front of the list. */
     public void addToTheLast(Node node) 
	 {
		
		  if (head == null) 
		  {
			head = node;
			
		  } else 
		  {
			   Node temp = head;
			   while (temp.next != null)
			   temp = temp.next;

		       temp.next = node;
		  }
	 }
  /* Function to print linked list */
    void printList(Node node)
    {
        Node temp = node;
        if(node != null)
        {
			do{
           System.out.print(temp.data+" ");
           temp = temp.next;
			}while (temp != node);
        }  
        System.out.println();
    }
	
	void circular()
	{
		    last = head;
			while (last.next != null)
				last = last.next;
			last.next = head;
			//System.out.println(last);
	}
	
	 
 
     /* Drier program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			circular_LinkedList llist = new circular_LinkedList();
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
            int a = sc.nextInt(); 
            llist.addToTheLast(new Node(a));
			
			
		     }
			 /*Node x = head;
			 while(x!=null)
			 {
				 System.out.print(x.data+" ");
				 x = x.next;
			 }*/
			llist.circular();
          //int k=sc.nextInt();
         gfg g = new gfg();
         //System.out.println(g.getCount(llist));
		 g.splitList(llist);
		 llist.printList(llist.head1);
		 llist.printList(llist.head2);
        //llist.printList();
		//llist.head = llist.reverse(llist.head);
		//llist.printList();
		
		
        t--;
    }
}
}// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class gfg
{
        // Function  to split a circular LinkedList
	    void splitList(circular_LinkedList list)
        {
            // Your code here
            
            //first motive is to find the middle element of the linked list.
            Node slow = list.head;
            Node fast = list.head.next;
            //why fast=list.head.next
            //because for the first condition it will be false..so inorder to
            //remove that..we are pointing fast to the next node..
            
            
            while(fast!=list.head && fast.next!=list.head)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
            
            //slow is pointing to the middle element
            
            
            list.head1=list.head;
            list.head2=slow.next;
            
            slow.next = list.head1; //point the next node of middle element to the head1 ..
            
            //now traverse from the (t node) till the end..
            Node t=list.head2;
            while(t.next!=list.head)
            {
                t=t.next;
            }
            
            //now point the last node to the head2.
            t.next = list.head2;

        }
}
