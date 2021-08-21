// Given a binary tree of size N, find its reverse level order traversal. ie- the traversal must begin from the last level.

// Example 1:

// Input :
//         1
//       /   \
//      3     2

// Output: 3 2 1
// Explanation:
// Traversing level 1 : 3 2
// Traversing level 0 : 1
// Example 2:

// Input :
//        10
//       /  \
//      20   30
//     / \ 
//    40  60

// Output: 40 60 20 30 10
// Explanation:
// Traversing level 2 : 40 60
// Traversing level 1 : 20 30
// Traversing level 0 : 10

// Your Task: 
// You dont need to read input or print anything. Complete the function reverseLevelOrder() which takes the root of the tree as input parameter and returns a list containing the reverse level order traversal of the given tree.


// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(N)

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
            ArrayList<Integer> ans = g.reverseLevelOrder(root);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}


 
// } Driver Code Ends



/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        
        /******************************************USING STACK AND QUEUE ( O(n) ) ******************************************************************/
        //this method will take O(n) time complexity.
       Stack<Node> s = new Stack<>();
        
        ArrayList<Integer> l = new ArrayList<>();
        if(node==null)
        {
            return l;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            Node temp = q.peek();
            s.push(temp);
            q.remove();
            if(temp.right!=null)
            {
                q.add(temp.right);
            }
            if(temp.left!=null)
            {
                q.add(temp.left);
            }
        }
        while(!s.isEmpty())
        {
            l.add(s.peek().data);
            s.pop();
        }
        return l;
        
/***********************************************ANOTHER  METHOD ( O(n^2) )*******************************************************************/        
        //another method using O(n^2) time complexity
        
        
        //first find the height of the Binary Tree..
        int h = height(node);
        
        int i;
        ArrayList<Integer> l = new ArrayList<>();
        //traverse from the last level of the binary tree.
        for(i=h;i>=1;i--)
        {
            reverse(node,i,l);
        }
        
        return l;
    }
    
    public static void reverse(Node node,int level,ArrayList<Integer> l)
    {
        //ArrayList<Integer> l = new ArrayList<>();
        if(node==null)//empty binary tree..
        { 
            return;
        }
        if(level==1)
        {
            l.add(node.data);
        }
        else if(level>1)
        {
            reverse(node.left,level-1,l);  //left side.
            reverse(node.right,level-1,l); //right side..
        }
        //return l;
    }
    
    public static int height(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        int h = Math.max(left,right)+1;
        return h;
    }
}      
