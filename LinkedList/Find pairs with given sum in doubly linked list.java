// Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is 
//equal to given value x, without using any extra space? 

// Example:  

// Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
//         x = 7
// Output: (6, 1), (5,2)
// The expected time complexity is O(n) and auxiliary space is O(1).



// Java program to find a
// pair with given sum x.
class GFG
{
 
// structure of node of
// doubly linked list
static class Node
{
    int data;
    Node next, prev;
};
 
// Function to find pair whose
// sum equal to given value x.
static void pairSum( Node head, int x)
{
    //so as it is the doubly linked list..
    //so take two pointers..first and last..
    Node first = head;
    Node temp = head; //this pointer is used for traversal.
    while(temp.next!=null)
    {
        temp=temp.next;
    }
    //now temp will be pointing to the last node..
     
    Node last = temp;
    
    //now simply use two pointer approach..
    //check this out..
    
    boolean found=false;// default..(no pair is there..)
    
    // The loop terminates when 
    // they cross each other (second.next
    // == first), or they become same
    // (first == second)
    while(first!=last && last.next!=first)
    {
        int sum = first.data+last.data;
        
        //if the sum of the first and last node data matches with the key value..
        if(sum==x)
        {
            if(found==false)//this will work one time..
            {
                found=true;
            }
            
            System.out.print("( "+first.data+" , "+last.data+" )  ");
            
            first = first.next;
            last = last.prev;
        }
        else if(sum>x)//sum is greater than x..
        {
            //move back one pointer.
            last = last.prev;
        }
        else if(sum<x)
        {
            first=first.next;
        }
    }
    
    //there will be a time..when first and the last node will be equal..
    
    //check if the key existed or not..
    
    if(found==false) //key is not there.
    {
        System.out.println("There are no two nodes whose value's sum is equal to the key value ");
    }
    
    //means key is there..and output is alredy shown on the screen.
}
 
// A utility function to insert
// a new node at the beginning
// of doubly linked list
static Node insert(Node head, int data)
{
    Node temp = new Node();
    temp.data = data;
    temp.next = temp.prev = null;
    if (head == null)
        (head) = temp;
    else
    {
        temp.next = head;
        (head).prev = temp;
        (head) = temp;
    }
    return temp;
}
 
// Driver Code
public static void main(String args[])
{
    Node head = null;
    head = insert(head, 9);
    head = insert(head, 8);
    head = insert(head, 6);
    head = insert(head, 5);
    head = insert(head, 4);
    head = insert(head, 2);
    head = insert(head, 1);
    int x = 7;
 
    pairSum(head, x);
}
}
