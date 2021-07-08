// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second)
    {
        // code here
        // return head of sum list
       
       //reverse both the linked list.
       first = reverse(first);
       second = reverse(second);
       
       int sum=0; //sum
       int c=0;  //carry
       
       //Node temp=null;  //creating a node.
       Node res = null;  //final list..
       Node curr = null;  //for current node.
       
       while(first!=null || second!=null)  //traverse till the end..
       {
           /*if(first==null)
           {
               first.data = 0;
           }
           if(second==null)
           {
               second.data=0;
           }*/
           sum = c + (first!=null ? first.data:0)+(second!=null ? second.data:0);
           
           c = sum/10;  //will check the carry..
           
           sum = sum%10;  //for sum greater than equal to 10.
           
           Node temp = new Node(sum);  //created a new node.
           
           if(res==null)  //for first node.
           {
               res = temp;
           }
           else
           {
               curr.next = temp;
           }
           curr = temp;
           
           if(first!=null)
           {
               first = first.next;
           }
           if(second!=null)
           {
               second = second.next;
           }
           
       }
       if(c!=0)
           {
               Node temp = new Node(c);
               curr.next = temp;
              curr = temp;
           }
           
       //now again reverse the final Linked List
       res = reverse(res);
       
        return res;
    }
    public static Node reverse(Node node)
    {
        Node prev = null;
        Node curr = node;
        Node next = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
}
