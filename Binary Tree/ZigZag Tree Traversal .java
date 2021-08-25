// Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

 

// Example 1:

// Input:
//         3
//       /   \
//      2     1
// Output:
// 3 1 2
// Example 2:

// Input:
//            7
//         /     \
//        9       7
//      /  \     /   
//     8    8   6     
//    /  \
//   10   9 
// Output:
// 7 7 9 8 8 6 9 10 
 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and returns a list containing the node values as they appear in the Zig-Zag Level-Order Traversal of the Tree.

 

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;
import java.io.*;

    class Node
    {
        int data;
        Node left,right;
        Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
    }
		
public class GFG2
{
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
    
	public static void inorder(Node root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
     /* Drier program to test above functions */
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    GFG g = new GFG();
			
			    ArrayList<Integer> res = g.zigZagTraversal(root) ;
			    for (int i = 0; i < res.size (); i++)
			        System.out.print (res.get (i) + " ");
			    System. out. println();  
    			
                t--;
            
        }
	}
}// } Driver Code Ends


//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    
	    ArrayList<Integer> zigzag = new ArrayList<>();
	    
	    //base condition
	    if(root==null)
	    {
	        return zigzag;
	    }
	    
	    
	    //take two stacks.(current_level and next_level)
	    Stack<Node> currentLevel = new Stack<>();
	    Stack<Node> nextLevel = new Stack<>();
	    boolean left_to_right=true; //this will keep track for the elements to 
	    //go from left to right or vice-versa..
	    
	    currentLevel.push(root); //push the root node.
	    while(!currentLevel.isEmpty())
	    {
	        Node curr = currentLevel.pop(); //pop the current node from current 
	        //and put the data in the result array list.
	        zigzag.add(curr.data);
	        
	        //now find the left and right subtree and based on the variable
	        //left_to_right push the node in the next level stack accordingly.
	        
	        if(left_to_right)//true
	        {
	            if(curr.left!=null)
	            {
	                nextLevel.push(curr.left);
	            }
	            if(curr.right!=null)
	            {
	                nextLevel.push(curr.right);
	            }
	        }
	        else //if it is false..
	        {
	            if(curr.right!=null)
	            {
	                nextLevel.push(curr.right);
	            }
	            if(curr.left!=null)
	            {
	                nextLevel.push(curr.left);
	            }
	        }
	       //now swap the current stack and next stack.
	       if(currentLevel.isEmpty())
	       {
	           //when the current level is empty then only swap it..
	           Stack<Node> temp = nextLevel;
	           nextLevel = currentLevel;
	           currentLevel = temp;
	           //change the path.
	           left_to_right = !left_to_right;
	       }
	       
	    }
	    return zigzag;
	}
}
