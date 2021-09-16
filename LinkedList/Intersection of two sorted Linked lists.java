// Given two lists sorted in increasing order, create a new list representing the intersection of the two lists. The new list should be made with its own memory — the original lists should not be changed.

// Example 1:

// Input:
// L1 = 1->2->3->4->6
// L2 = 2->4->6->8
// Output: 2 4 6
// Explanation: For the given first two
// linked list, 2, 4 and 6 are the elements
// in the intersection.
// Example 2:

// Input:
// L1 = 10->20->40->50
// L2 = 15->40
// Output: 40
// Your Task:
// The task is to complete the function intersection() which should find the intersection of two linked list and add all the elements in intersection to the third linked list and return the head of the third linked list.

// Expected Time Complexity : O(n+m)
// Expected Auxilliary Space : O(n+m)
// Note: n,m are the size of the linked lists.



// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
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

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        
        //two pointer method..(used for traversing both the linked lists and 
        //comparing method..)
        Node temp1 = head1;
        Node temp2 = head2;
        
        Node curr=null; //this pointer will traverse the new linked list.. 
        Node head=null; //this will be the pointer of the final linked list.
        
        while(temp1!=null && temp2!=null)
        {
            if(temp1.data==temp2.data)
            {
                if(head==null)
                {
                    Node t = new Node(temp1.data);
                    head=t;
                    curr=t;
                }
                else//when head is already appointed..
                {
                    Node t = new Node(temp1.data);
                    curr.next=t;
                    curr=curr.next;
                }
                
                temp1=temp1.next;
                temp2=temp2.next;
                
            }
            else if(temp1.data<temp2.data)
            {
                temp1=temp1.next;
            }
            else if(temp2.data<temp1.data && temp2.next!=null)
            {
                temp2=temp2.next;
            }
        }
        return head;
    }
}
