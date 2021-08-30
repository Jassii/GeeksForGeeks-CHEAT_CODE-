// Given a Binary Tree of size N , where each node can have positive or negative values. Convert this to a tree where each node contains the sum of the left and right sub trees of the original tree. The values of leaf nodes are changed to 0.

// Example 1:

// Input:
//              10
//           /      \
//         -2        6
//        /   \     /  \
//      8     -4   7    5

// Output:
//             20
//           /    \
//         4        12
//        /  \     /  \
//      0     0   0    0

// Explanation:

//            (4-2+12+6)
//           /           \
//       (8-4)          (7+5)
//        /   \         /  \
//       0     0       0    0
 

// Your Task:  
// You dont need to read input or print anything. Complete the function toSumTree() which takes root node as input parameter and modifies the given tree in-place.

// Note: If you click on Compile and Test the output will be the in-order traversal of the modified tree.


// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(height of tree)

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
        	    Solution ob = new Solution();
        	    ob.toSumTree(root);
        	    printInorder(root);
        	    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


//User function template for JAVA

/*Complete the Given Function

Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}*/

class Solution
{
    public void toSumTree(Node root)
    {
         //add code here.
         
         //base condition
         if(root==null)
         {
             return;
         }
         
         //now will be doing simple traversal and for each node..will be calculating
         //the sum of its left and right subtree..
         
         Queue<Node> q = new LinkedList<>();
         q.add(root);
         
         while(!q.isEmpty())
         {
             Node curr = q.poll();
             int sum = Sum(curr.left) + Sum(curr.right);
             
             //update the curr node data..
             curr.data = sum;
             
             if(curr.left!=null)
             {
                 q.add(curr.left);
             }
             
             if(curr.right!=null)
             {
                 q.add(curr.right);
             }
         }
    }
    
    public int Sum(Node curr)
    {
        //base condition..
        if(curr==null)
        {
            return 0;
        }
        
        int sum=0;
        Queue<Node> q = new LinkedList<>();
        q.add(curr);
        
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            sum = sum+temp.data;
            
            if(temp.left!=null)
            {
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
            }
        }
        
        return sum;
    }
}
