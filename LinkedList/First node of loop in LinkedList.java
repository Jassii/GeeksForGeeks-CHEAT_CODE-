// Find first node of loop in a linked list

// Write a function findFirstLoopNode() that checks whether a given Linked List contains a loop. If the loop is present then it returns point to the first node of the loop. Else it returns NULL.

// We have discussed Floyd’s loop detection algorithm. Below are steps to find the first node of the loop.
// 1. If a loop is found, initialize a slow pointer to head, let fast pointer be at its position. 
// 2. Move both slow and fast pointers one node at a time. 
// 3. The point at which they meet is the start of the loop.

/**************************************************************************************************************************/

// Java program to return
// first node of loop.
import java.util.*;
class GFG{
 
static class Node
{
  int key;
  Node next;
};
 
static Node newNode(int key)
{
  Node temp = new Node();
  temp.key = key;
  temp.next = null;
  return temp;
}
 
// A utility function to
// print a linked list
static void printList(Node head)
{
  while (head != null)
  {
    System.out.print(head.key + " ");
    head = head.next;
  }
  System.out.println();
}

static Node detectAndRemoveLoop(Node head)
{
    if(head==null && head.next==null)
    {
        return null;
    }
    Node slow = head;
    Node fast = head;
    while(fast!=null && fast.next!=null)
    {
        slow = slow.next;
        fast = fast.next.next;
        if(slow==fast)
        {
            break;
        }
    }
    if(slow!=fast)
    {
        return null;
    }
    //means that slow and fast are equal..
    fast=head;
    if(slow!=fast)
    {
        while(fast.next!=slow.next)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }
    else
    {
        return slow;
    }
}

public static void main(String[] args)
{
  Node head = newNode(50);
  head.next = newNode(20);
  head.next.next = newNode(15);
  head.next.next.next = newNode(4);
  head.next.next.next.next = newNode(10);
 
  // Create a loop for testing
  head.next.next.next.next.next = head.next.next;
 
  Node res = detectAndRemoveLoop(head);
  if (res == null)
    System.out.print("Loop does not exist");
  else
    System.out.print("Loop starting node is " +  res.key);
}
}
