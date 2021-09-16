// Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

 

// Example 1:

// Input:
// LinkList1 = 3->6->9->common
// LinkList2 = 10->common
// common = 15->30->NULL
// Output: 15
  
//   Input: 
// Linked List 1 = 4->1->common
// Linked List 2 = 5->6->1->common
// common = 8->4->5->NULL
// Output: 8
// Explanation: 

// 4              5
// |              |
// 1              6
//  \             /
//   8   -----  1 
//    |
//    4
//    |
//   5
//   |
//   NULL       
// Your Task:
// You don't need to read input or print anything. The task is to complete the function intersetPoint() which takes the pointer to the head of linklist1(head1) and linklist2(head2) as input parameters and returns data value of a node where two linked lists intersect. If linked list do not merge at any point, then it should return -1.
// Challenge : Try to solve the problem without using any extra space.

 

// Expected Time Complexity: O(N+M)
// Expected Auxiliary Space: O(1)



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
	
 class LinkedList_Intersection
{
    Node head = null;  
	Node tail = null;

public void addToTheLast(Node node) 
{

  if (head == null) {
   head = node;
   tail = head;
  } else {
   //Node temp = head;
   //while (temp.next != null)
    //temp = temp.next;

   //temp.next = node;
   tail.next=node;
   tail = node;
  }
}

  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			LinkedList_Intersection llist1 = new LinkedList_Intersection();
		    LinkedList_Intersection llist2 = new LinkedList_Intersection();
			LinkedList_Intersection llist3 = new LinkedList_Intersection();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				Node tail1= head1;
				
				for (int i = 1; i < n1; i++) 
				{
					int a = sc.nextInt(); 
					tail1.next = (new Node(a));
					tail1= tail1.next;
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				Node tail2 = head2;
				for (int i = 1; i < n2; i++) 
				{
					int b = sc.nextInt();  
					tail2.next = (new Node(b));
					tail2= tail2.next;
				}
				
				int c1=sc.nextInt();
				Node head3= new Node(c1);
				tail1.next = head3;
				tail2.next = head3;
				Node tail3=head3;
				for (int i = 1; i < n3; i++) 
				{
					int c = sc.nextInt();   
					tail3.next = (new Node(c));
					tail3= tail3.next;
				}
				
				Intersect obj = new Intersect();
				System.out.println(obj.intersectPoint(head1, head2));
			t--;			
         }
    }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here
         
         //first find the size of both the linked lists..
         int c1=0; //for first linked list.
         int c2=0; //for second linked list.
         
         //pointer pointing head of both the linked lists
         Node temp1=head1;
         Node temp2=head2;
        
         //length of the first linked list.
         while(temp1!=null)
         {
             c1++;
             temp1=temp1.next;
         }
         
         //length of the second linked list.
         while(temp2!=null)
         {
             c2++;
             temp2=temp2.next;
         }
         
         //now i have number of nodes for both of the linked list..
         int dif=Math.abs(c1-c2);
         
         //move the pointer of the first linked list..to same length 
         if(c1>c2)
         {
             for(int i=1;i<=dif;i++)
             {
                 head1=head1.next;
             }
         }//move the pointer of the second linked list..to same length 
         else if(c2>c1)
         {
             for(int i=1;i<=dif;i++)
             {
                 head2=head2.next;
             }
         }
         
         //after the movement is done..
         
         //now it's time to compare the elements..
         temp1=head1;
         temp2=head2;
         
         //check if both are same..and it should not be null..
         while(temp1!=temp2 && (temp1!=null || temp2!=null))
         {
             temp1=temp1.next;
             temp2=temp2.next;
         }
         
         //this will be the time
         if(temp1==temp2)
         {
             return temp1.data;
         }
         
         //if both or any of them i null..then return -1..
         return -1;
         
	}
}
