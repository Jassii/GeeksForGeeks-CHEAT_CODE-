// Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x. 
// Count triplets in the list that sum up to a given value x.
  

import java.util.*;
 
class GFG{
  
// structure of node of doubly linked list
static class Node {
    int data;
    Node next, prev;
    Node(int val)
    {
        data = val;
        prev = null;
        next = null;
    }
};
  
// function to count triplets in a sorted doubly linked list
// whose sum is equal to a given value 'x'

  
  (................................................................taking time complexity of O(n^2) .............................................................................
//done this question similar with the array problem...
static int countTriplets(Node head, int x)
{
   //now its time to find the triplets..
   Node temp=head;
   
   int count=0;  //count the number of triplets..
   
   //inorder to avoid null pointer exception.(so that 3 elements can be taken)..
   while(temp.next.next.next!=null)
   {
       //current difference..
       int current = x-temp.data; 
       
       //taking set..
       Set<Integer> set = new HashSet<>();
       Node temp1=temp.next;
       while(temp1!=null)
       {
           if(set.contains(current-temp1.data))  //another difference..
           {
               count++;
           }
           else
           {
               set.add(temp1.data); //if it is not there..then simply add the data(temp1).
           }
           temp1=temp1.next;
       }
       temp=temp.next;
   }
   return count;  //return the count of the triplets matching..
}
  
// A utility function to insert a new node at the
// beginning of doubly linked list
static Node insert(Node head, int val)
{
        // allocate node
        Node temp = new Node(val);
 
        if (head == null)
            head = temp;
 
        else
        {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
      
        return head;
}
  
// Driver program to test above
public static void main(String[] args)
{
    // start with an empty doubly linked list
    Node head = null;
  
    // insert values in sorted order
    head = insert(head, 9);
    head = insert(head, 8);
    head = insert(head, 6);
    head = insert(head, 5);
    head = insert(head, 4);
    head = insert(head, 2);
    head = insert(head, 1);
  
    int x = 17;
  
    System.out.print("Count = "
         + countTriplets(head, x));
}
}
