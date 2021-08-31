// Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 

// Example 1:

// Input:
// N = 4
// inorder[] = {1 6 8 7}
// preorder[] = {1 6 7 8}
// Output: 8 7 6 1
// Example 2:

// Input:
// N = 6
// inorder[] = {3 1 4 0 5 2}
// preorder[] = {0 1 3 4 2 5}
// Output: 3 4 1 5 2 0
// Explanation: The tree will look like
//        0
//     /     \
//    1       2
//  /   \    /
// 3    4   5
// Your Task:
// Your task is to complete the function buildTree() which takes 3 arguments(inorder traversal array, preorder traversal array, and size of tree n) and returns the root node to the tree constructed. You are not required to print anything and a new line is added automatically (The post order of the returned tree is printed by the driver's code.)

// Expected Time Complexity: O(N*N).
// Expected Auxiliary Space: O(N).

// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    //so that its value is not created again and again..
    static int preI=0; 
    
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        
        //we will fix the start and the end node for the inorder array..
        Node root = solve(inorder,preorder,0,n-1);
        return root;
    }
    
    
    public static Node solve(int in[], int pre[],int inStart,int inEnd)
    {
        
        //default condition..
        if(inStart>inEnd)
        {
            return null;
        }
        
        //create a node.
        int curr = pre[preI++];
        
        Node node = new Node(curr);
        
        if(inStart==inEnd)
        {
            return node;
        }
        
        //index of the root data in inorder array..
        int index = search(in,inStart,inEnd,curr);
        
        node.left = solve(in,pre,inStart,index-1);
        node.right = solve(in,pre,index+1,inEnd);
        
        return node;
    }
    
    public static int search(int in[],int start,int end,int value)
    {
        for(int i=start;i<=end;i++)
        {
            if(in[i]==value)
            {
                return i;
            }
        }
        return -1;
    }
}
