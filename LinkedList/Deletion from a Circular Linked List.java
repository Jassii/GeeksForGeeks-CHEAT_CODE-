// We will be given a node and our task is to delete that node from the circular linked list.

// Examples: 

// Input : 2->5->7->8->10->(head node)
//         data = 5
// Output : 2->7->8->10->(head node)

// Input : 2->5->7->8->10->(head node)
//          7
// Output : 2->5->8->10->(head node)
// Algorithm
// Case 1: List is empty. 




// If the list is empty we will simply return.
// Case 2:List is not empty  

// If the list is not empty then we define two pointers curr and prev and initialize the pointer curr with the head node.
// Traverse the list using curr to find the node to be deleted and before moving to curr to the next node, every time set prev = curr.
// If the node is found, check if it is the only node in the list. If yes, set head = NULL and free(curr).
// If the list has more than one node, check if it is the first node of the list. 
//Condition to check this( curr == head). If yes, then move prev until it reaches the last node. 
//After prev reaches the last node, set head = head -> next and prev -> next = head. Delete curr.
// If curr is not the first node, we check if it is the last node in the list. Condition to check this is (curr -> next == head).
// If curr is the last node. Set prev -> next = head and delete the node curr by free(curr).
// If the node to be deleted is neither the first node nor the last node, then set prev -> next = curr -> next and delete curr.

// Java program to delete a given key from
// linked list.
class GFG {
 
    /* ure for a node */
    static class Node {
        int data;
        Node next;
    };
 
    /* Function to insert a node at the beginning of
a Circular linked list */
    static Node push(Node head_ref, int data)
    {
        // Create a new node and make head as next
        // of it.
        Node ptr1 = new Node();
        ptr1.data = data;
        ptr1.next = head_ref;
 
        /* If linked list is not null then set the
    next of last node */
        if (head_ref != null) {
            // Find the node before head and update
            // next of it.
            Node temp = head_ref;
            while (temp.next != head_ref)
                temp = temp.next;
            temp.next = ptr1;
        }
        else
            ptr1.next = ptr1; /*For the first node */
 
        head_ref = ptr1;
        return head_ref;
    }
 
    /* Function to print nodes in a given
circular linked list */
    static void printList(Node head)
    {
        Node temp = head;
        if (head != null) {
            do {
                System.out.printf("%d ", temp.data);
                temp = temp.next;
            } while (temp != head);
        }
 
        System.out.printf("\n");
    }
 
    /* Function to delete a given node from the list */
    static Node deleteNode(Node head, int key)
    {
        //when list is empty
        if(head==null)
        {
            return null;
        }
        
        //means that list is not empty
        //we will define two pointers.
        Node prev=null;  //one before head.
        Node curr=head;  //point to the head.
        
        while(curr.data!=key && curr.next!=head) //should not circular as well.
        {
            prev=curr;
            curr=curr.next;
        }
        
        
        //means that while loop not executed..(only one node is there..)
        if(prev==null)
        {
            if(curr.data==key) //if the first node matches with the key value.
            {
                head=null;
                return head;
            }
            else  //if the only node value doesn't matches with the key value.
            {
                return head;
            }
        }
        
        //suppose that the list has been traversed and curr.data!=key.
        //(key is not present in the list)
        if(prev!=null && curr.data!=key)
        {
            return head;
        }
        
        
        //now suppose that the curr data matches with the key passed and prev!=null
        //just simply make the connection..
        prev.next=curr.next;
        curr.next=null; 
        return head;
        
    }
 
    /* Driver code */
    public static void main(String args[])
    {
        /* Initialize lists as empty */
        Node head = null;
 
        /* Created linked list will be 2.5.7.8.10 */
        head = push(head, 2);
        head = push(head, 5);
        head = push(head, 7);
        head = push(head, 8);
        head = push(head, 10);
 
        System.out.printf("List Before Deletion: ");
        printList(head);
 
        head = deleteNode(head, 2);
 
        System.out.printf("List After Deletion: ");
        printList(head);
    }
}
