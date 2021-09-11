//  Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of all nodes on the longest path from root to leaf node.
// If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

// Example 1:

// Input: 
//         4        
//        / \       
//       2   5      
//      / \ / \     
//     7  1 2  3    
//       /
//      6
// Output: 13
// Explanation:
//         4        
//        / \       
//       2   5      
//      / \ / \     
//     7  1 2  3 
//       /
//      6

// The highlighted nodes (4, 2, 1, 6) above are 
// part of the longest root to leaf path having
// sum = (4 + 2 + 1 + 6) = 13
// Example 2:

// Input: 
//           1
//         /   \
//        2     3
//       / \   / \
//      4   5 6   7
// Output: 11
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function sumOfLongRootToLeafPath() which takes root node of the tree as input parameter and returns an integer denoting the sum of the longest root to leaf path of the tree. If the tree is empty, return 0.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N)

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
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
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int res = obj.sumOfLongRootToLeafPath(root);
		    System.out.println(res);
		}
	}
}// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution
{
    static int maxS;
    static int maxL;
    
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        
        maxS=Integer.MIN_VALUE;  //max sum
        maxL=0; //max level
        
        maxSum(root,0,0);  //(root,sum-->0,level-->0)  initially
        
        return maxS;
    }
    public void maxSum(Node root,int sum,int level)
    {
        //means we traversed root to the leaf path.
        if(root==null)
        {
            if(maxL<level)
            {
                maxL=level;
                maxS=sum;
            }
            else if(maxL==level && maxS<sum)
            {
                maxS=sum;
            }
            return;
        }
        maxSum(root.left,sum+root.data,level+1);
        maxSum(root.right,sum+root.data,level+1);
    }
}
