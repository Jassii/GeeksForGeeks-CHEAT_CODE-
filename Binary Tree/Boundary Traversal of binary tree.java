// Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

// Left boundary nodes: defined as the path from the root to the left-most node ie-
//the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
// Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
// Reverse right boundary nodes: defined as the path from the right-most node to the root. 
//The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
// Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

// Example 1:

// Input:
//         1
//       /   \
//      2     3    
   
// Output: 1 2 3
// Explanation:


// Example 2:

// Input:
//           20
//         /   \
//        8     22
//      /   \    \
//     4    12    25
//         /  \ 
//        10   14 

// Output: 20 8 4 10 14 25 22
// Explanation: 


// Your Task:
// This is a function problem. You don't have to take input. 
//Just complete the function printBoundary() that takes the root node as input and returns an array containing the boundary values in anti-clockwise.

 

// Expected Time Complexity: O(N). 
// Expected Auxiliary Space: O(Height of the Tree).


// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.printBoundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> printBoundary(Node node)
	{
	    //base condition
	    if(node==null)
	    {
	        return new ArrayList<Integer>();
	    }
	    
	    ArrayList<Integer> boundary = new ArrayList<Integer>();
	    
	    boundary.add(node.data); //basic thing..
	    
	    //function for left boundary nodes.
	    leftNodes(node.left,boundary);
	    
	    //function for leaf nodes.
	    leafNodes(node,boundary);
	    
	    //function for reverse right boundary nodes.
	    rightNodes(node.right,boundary);
	    
	    return boundary;
	    
	    
	}
	public void rightNodes(Node node,ArrayList<Integer> b)
	{
	    if(node==null)
	    {
	        return;
	    }
	    if(node.right!=null)
	    {
	        rightNodes(node.right,b);
	        b.add(node.data);
	    }
	    else if(node.left!=null)
	    {
	        rightNodes(node.left,b);
	        b.add(node.data);
	    }
	    
	}
	public void leafNodes(Node node,ArrayList<Integer> b)
	{
	    if(node==null)
	    {
	        return;
	    }
	    leafNodes(node.left,b);
	    if(node.left==null && node.right==null)
	    {
	        b.add(node.data);
	    }
	    leafNodes(node.right,b);
	}
	
	
	public void leftNodes(Node node,ArrayList<Integer> b)
	{
	    if(node==null)
	    {
	        return;
	    }
	    if(node.left!=null)
	    {
	        b.add(node.data);
	        leftNodes(node.left,b);
	    }
	    else if(node.right!=null)
	    {
	        b.add(node.data);
	        leftNodes(node.right,b);
	    }
	}
}
