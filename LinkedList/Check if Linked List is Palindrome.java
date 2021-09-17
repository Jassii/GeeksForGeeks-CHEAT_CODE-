// { Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}



// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        //Your code here
        
        /*//i am not supposed to take the stack
        Stack<Node> S = new Stack<Node>();
        Node temp=head;
        while(temp!=null)
        {
            S.push(temp);
            temp=temp.next;
        }
    
        temp=head;
        while(temp!=null)
        {
            //i am supposed to match the data..
            //not simply compare the nodes..
            if(temp.data!=S.pop().data) 
            {
                return false;
            }
            temp=temp.next;
        }
        return true;*/
        
        /***************************NOT USING ANY STACK************************************************/
        //O(1) SPACE COMPLEXITY.
        /********************************* MUCH SUITABLE APPROACH RATHER THAN USING ANY STACK***************************************************************************************/
        
        //will be doing with some other approach..
        //find the middle node of the linked list
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //now slow pointer is pointing to the middle node.
        //now reverse the list after the middle node..
        //  1->3->2<-3<-1  here 2 is the middle node of the linked list..
        
        
        //reverse the linked list after the middle node..
        Node prev=null;
        Node next=null;
        Node curr=slow;
        
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        //now prev will be the new head for the reverse linked list.
        Node head2=prev; 
        
        //  (head)1->3->2<-3<-1(head2)..
        
        //head is pointing to the first node..
        //head2 is pointing to the last node..
        
        //will be using two pointer approach..(and compare both of them)
        Node temp1=head;  //pointing to the first node.
        Node temp2=head2; //pointing to the last node.
        
        while(temp1!=null && temp2!=null)
        {
            //compare the data..if it doesn't matches..then simply return false..
            if(temp1.data!=temp2.data)
            {
                return false;
            }
            //else move forward in the linked list..
            temp1=temp1.next;
            temp2=temp2.next;
        }
        
        //if nothing happens, means everything is correct..(return true..)
        return true;
    }    
}
