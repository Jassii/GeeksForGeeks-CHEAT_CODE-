// Given a binary tree, find if it is height balanced or not. 
// A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

// A height balanced tree
//         1
//      /     \
//    10      39
//   /
// 5

// An unbalanced tree
//         1
//      /    
//    10   
//   /
// 5

// Example 1:

// Input:
//       1
//     /
//    2
//     \
//      3 
// Output: 0
// Explanation: The max difference in height
// of left subtree and right subtree is 2,
// which is greater than 1. Hence unbalanced
// Example 2:

// Input:
//        10
//      /   \
//     20   30 
//   /   \
//  40   60
// Output: 1
// Explanation: The max difference in height
// of left subtree and right subtree is 1.
// Hence balanced. 
// Your Task:
// You don't need to take input. Just complete the function isBalanced() that takes root node as parameter and returns true, if the tree is balanced else returns false.

// Constraints:
// 1 <= Number of nodes <= 105
// 0 <= Data of a node <= 106

// Expected time complexity: O(N)
// Expected auxiliary space: O(h) , where h = height of tree

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
			
			    if(g.isBalanced(root) == true)
    			    System.out.println(1);
    			else 
    			    System.out.println(0);
                t--;
            
        }
    }
  
}

// } Driver Code Ends


//User function Template for Java


/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */

class Tree
{
    
	/*******************************************************FIRST METHOD******************************************************************/
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        // Your code here
        if(root==null)
        {
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        
        if((int)Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right))
        {
            return true;
        }
        return false;
    }
    static int height(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int h = Math.max(lh,rh);  //maximum height..
        return h+1;
    }
	/****************************SECOND METHOD********************************************************************************************************/
	
	boolean isBalanced(Node root)
    {
        // Your code here
        
        //for every node difference b/w the left and right subtree is atmost 1.
        
        //base condition
        if(root==null)
        {
            return true;
        }
        
        //traverse the Binary Tree..
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
        
            Node curr = q.poll();
            
            //for current node find the max left height and the right height..
            int lh = height(curr.left);  //left height..
            int rh = height(curr.right);  //right height..
            
            //find the difference.
            int dif = Math.abs(lh-rh);
            
            //for unbalanced binary tree..
            if(dif>1)
            {
                return false;
            }
        
            if(curr.left!=null)
            {
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
            }
        }
        return true;
    }
    
    int height(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        
        int l = height(node.left); //left subtree height..
        int r = height(node.right); //right subtree height..
        int h = Math.max(l,r)+1;
        return h;
    }
}
