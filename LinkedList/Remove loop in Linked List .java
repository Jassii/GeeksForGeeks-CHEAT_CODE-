// Given a linked list of N nodes such that it may contain a loop.

// A loop here means that the last node of the link list is connected to the node at position X. If the link list does not have any loop, X=0.

// Remove the loop from the linked list, if it is present.  


// Example 1:

// Input:
// N = 3
// value[] = {1,3,4}
// X = 2
// Output: 1
// Explanation: The link list looks like
// 1 -> 3 -> 4
//      ^    |
//      |____|    
// A loop is present. If you remove it 
// successfully, the answer will be 1. 

// Example 2:

// Input:
// N = 4
// value[] = {1,8,3,4}
// X = 0
// Output: 1
// Explanation: The Linked list does not 
// contains any loop. 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function removeLoop() which takes the head of the linked list as input parameter. Simply remove the loop in the list (if present) without disconnecting any nodes from the list.
// Note: The generated output will be 1 if your submitted code is correct.


// Expected time complexity : O(N)
// Expected auxiliary space : O(1)

/*****************************************************************************************************************************/
// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            Solution x = new Solution();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head)
    {
        // code here
        // remove the loop without losing any nodes
        
        //Base Case.
        if(head==null || head.next==null)
        {
            return;
        }
        
        //now its time to detect the cycle..
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;  //by one place..
            fast = fast.next.next;  //by two place..
            if(slow==fast)  //if it matches..
            {
                break;
            }
        }
        
        //if loop exists..
        if(slow==fast)//if they both are equal..
        {
            fast = head;  //move the fast to the head..
            //if they both are not equal..
            if(slow!=fast)
            {
                while(fast.next!=slow.next)  //find the next node where it matches.
                {
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = null;  
            }
            else  //if they matches...
            {
                while(fast.next!=slow)  //then traverse only the fast node.till its next
                //matches with the slow..
                {
                    fast = fast.next;
                }
                fast.next = null;  //as it matches point it to the null.
            }
        }
    }
}
