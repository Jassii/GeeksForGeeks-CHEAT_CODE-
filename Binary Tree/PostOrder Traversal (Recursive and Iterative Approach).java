// Given a binary tree, find the Postorder Traversal of it.
// For Example, the postorder traversal of the following tree is:
// 5 10 39 1

//         1
//      /     \
//    10     39
//   /
// 5


// Example 1:

// Input:
//         19
//      /     \
//     10      8
//   /    \
//  11    13
// Output: 11 13 10 8 19
// Example 2:

// Input:
//           11
//          /
//        15
//       /
//      7
// Output: 7 15 11

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function postOrder() that takes root node as input and returns an array 
//containing the postorder traversal of the given Binary Tree.


// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).

// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	Tree g = new Tree();
                ArrayList<Integer> res = g.postOrder(root);
                for (int i = 0; i < res.size (); i++)
                    System.out.print (res.get (i) + " ");
                System.out.print("\n");
                t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

/* A Binary Tree node
class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree
{
    //
    
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       // Your code goes here
       
       //Recursion Approach to solve this problem.
       
       //base condition
       if(root==null)
       {
           return post;
       }
       
       //for left subtree..
       postOrder(root.left);
       //for roght subtree..
       postOrder(root.right);
       //in the end visit the node.
       post.add(root.data);
       
       return post;
       
       
       //trying to do solve this problem using iterative approach..
       ArrayList<Integer> post = new ArrayList<>();
       
       //here will take 2 stacks.
       Stack<Node> S = new Stack<>();
       Stack<Node> T = new Stack<>();
       S.push(root);
       
       Node popped=null;  //popped node from the S to be pushed into T.
       while(!S.isEmpty())
       {
           popped = S.pop();
           T.push(popped);
           
           //now push the left and right child of the popped node in S stack...
           if(popped.left!=null)
           {
               S.push(popped.left);
           }
           if(popped.right!=null)
           {
               S.push(popped.right);
           }
       }
       
       //now after this..pop the T stack..and add all the elements from the top
       //in the list.
       while(!T.isEmpty())
       {
           post.add(T.pop().data);
       }
       return post;
    }
}
