// Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
// Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

// Example 1:

// Input:
// N = 5
// value[]  = {3,5,2,4,1}
// Output: 1 2 3 4 5
// Explanation: After sorting the given
// linked list, the resultant matrix
// will be 1->2->3->4->5.
// Example 2:

// Input:
// N = 3
// value[]  = {9,15,0}
// Output: 0 9 15
// Explanation: After sorting the given
// linked list , resultant will be
// 0->9->15.
// Your Task:
// For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
// For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

// Expected Time Complexity: O(N*Log(N))
// Expected Auxiliary Space: O(N)


// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}


// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        
        //base condition
        if(head==null || head.next==null)
        {
            return head;
        }
        
        //function to find the middle node of the list..
        Node middle = FindMiddle(head);  
        
        //next node of the middle node will be the head of the second list.
        Node nextofmiddle = middle.next;
        
        //to create a first list.
        middle.next = null;
        
        //dividing..
        
        //first list head.
        Node left = mergeSort(head);
        
        //second list head.
        Node right = mergeSort(nextofmiddle);
        
        //sorted list formation..(conquering)
        Node sortedlist = sortedMerge(left,right);
        
        return sortedlist;
    }
    
    //now merge method(conquer)
    static Node sortedMerge(Node first,Node second)
    {
        //now list will be created..(merged list)..
        Node answer=null;
        
        //below conditions will be used as a terminating condition..
        
        //if first is empty
        if(first==null)
        {
            return second;
        }
        
        //if second is empty..
        if(second==null)
        {
            return first;
        }
        
        if(first.data<=second.data)
        {
            answer = first;
            answer.next = sortedMerge(first.next,second);
        }
        else
        {
            answer=second;
            answer.next = sortedMerge(first,second.next);
        }
        
        return answer;
    }
    
    
    
    //this function will help in finding the middle element in the linked list..
    static Node FindMiddle(Node curr)
    {
        Node slow=curr;
        Node fast=curr.next;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
