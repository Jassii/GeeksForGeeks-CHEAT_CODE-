// Given a Binary Tree, print the diagonal traversal of the binary tree.

// Consider lines of slope -1 passing between nodes. Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.

// Example 1:

// Input :
//             8
//          /     \
//         3      10
//       /   \      \
//      1     6     14
//          /   \   /
//         4     7 13
// Output : 8 10 14 3 6 7 13 1 4
// Explanation:
// unnamed
// Diagonal Traversal of binary tree : 
//  8 10 14 3 6 7 13 1 4
// Your Task:
// You don't need to read input or print anything. The task is to complete the function diagonal() that takes the root node as input argumets and returns the diagonal traversal of the given tree.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).
// Here N is number of nodes.


// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
			    ArrayList<Integer> diagonalNode = g.diagonal(root);
			    for(int i = 0 ;i<diagonalNode.size();i++){
			        System.out.print(diagonalNode.get(i)+ " ");
			    }
		        System.out.println();
	        }
	}
}


// } Driver Code Ends


//User function Template for Java

/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           
           ArrayList<Integer> diagnol = new ArrayList<>();
           
           //base condition
           if(root==null)
           {
               return diagnol;
           }
           
           Queue<Node> q = new LinkedList<>();
           q.add(root);
       //MY WAY********************************************************************************
           while(!q.isEmpty())
           {
               Node curr = q.poll();
               diagnol.add(curr.data);
               
               if(curr.left!=null)
               {
                   q.add(curr.left);
               }
               
               //if right side is present
               while(curr.right!=null)
               {
                   //for rest of the right nodes.
                   curr = curr.right;
                   diagnol.add(curr.data);
                   
                   if(curr.left!=null)
                   {
                       q.add(curr.left);
                   }
               }
           }
       
       //ANOTHER WAY*****************************************************************************************************
           while(!q.isEmpty())
           {
               Node curr = q.poll();
               
               while(curr!=null)//traverse till the current exists..
               {
                   if(curr.left!=null)
                   {
                       q.add(curr.left);
                   }
                   diagnol.add(curr.data);
                   
                   curr = curr.right;
               }
           }
           return diagnol;
      }
}
