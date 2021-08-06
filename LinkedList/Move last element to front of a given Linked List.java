// Write a function that moves the last element to the front in a given Singly Linked List. For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4.

// Algorithm:
// Traverse the list till last node. Use two pointers: one to store the address of last node and other for address of second last node. After the end of loop do following operations.
// i) Make second last as last (secLast->next = NULL).
// ii) Set next of last as head (last->next = *head_ref).
// iii) Make last as head ( *head_ref = last)

/************************************************************************************************************************************************/

class LinkedList
{
    Node head;  // head of list
   
    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    
    public void moveToFront()
    {
        if(head==null || head.next==null)
        {
            return;
        }
        
        Node last = head;
        Node secondLast = null;
        
        /* After this loop secLast contains address of 
           second last  node and last contains address of 
           last node in Linked List */
        while(last.next!=null)
        {
            secondLast = last;
            last = last.next;
        }
        
        //now we have two nodes..which tells about the last and the secondLast.node..
        last.next = head;
        /* Set the next of second last as null */
        secondLast.next = null;
        /* Change head to point to last node. */
        head = last;
    }
    
    
    
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
   
        /* 3. Make next of new Node as head */
        new_node.next = head;
   
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
  
    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
  
     /* Driver program to test above functions */
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
          
        System.out.println("Linked List before moving last to front ");
        llist.printList();
          
        llist.moveToFront();
          
        System.out.println("Linked List after moving last to front ");
        llist.printList();
    }
} 
