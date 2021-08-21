// Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom 
// (i.e. the deleted node is replaced by the bottom-most and rightmost node). This is different from BST deletion.
// Here we do not have any order among elements, so we replace with the last element.
// Algorithm 
// 1. Starting at the root, find the deepest and rightmost node in binary tree and node which we want to delete. 
// 2. Replace the deepest rightmost node’s data with the node to be deleted. 
// 3. Then delete the deepest rightmost node.
    


// Java program to delete element
// in binary tree
import java.util.LinkedList;
import java.util.Queue;
 
class GFG{
     
// A binary tree node has key, pointer to
// left child and a pointer to right child
static class Node
{
    int key;
    Node left, right;
     
    // Constructor
    Node(int key)
    {
        this.key = key;
        left = null;
        right = null;
    }
}
 
static Node root;
static Node temp = root;
 
// Inorder traversal of a binary tree
static void inorder(Node temp)
{
    if (temp == null)
        return;
 
    inorder(temp.left);
    System.out.print(temp.key + " ");
    inorder(temp.right);
}
 
// Function to delete deepest
// element in binary tree
static void deleteDeepest(Node root,Node delNode)
{
    //do a simple traversal in the Binary tree..
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    
    while(!q.isEmpty())
    {
        Node temp = q.peek();
        q.remove();
        
        if(temp==delNode)
        {
            temp = null;
            return;
        }
        if(temp.right!=null)
        {
            if(temp.right==delNode)
            {
                temp.right=null;
                return;
            }
            else
            {
                q.add(temp.right);
            }
        }
        if(temp.left!=null)
        {
            if(temp.left==delNode)
            {
                temp.left=null;
                return;
            }
            else
            {
                q.add(temp.left);
            }
        }
    }
}
 
// Function to delete given element
// in binary tree
static void delete(Node root, int key)
{
    //base condition.
    if(root==null)
    {
        return;
    }
    
    //now child nodes..
    if(root.left==null && root.right==null)
    {
        if(root.key==key)
        {
            root=null;
            return;
        }
        else
        {
            return;
        }
    }
    
    
    //now we will be traversing the Binary tree finding the Node with the key value.
    Node to_be_deleted=null;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    Node temp=null;
    while(!q.isEmpty())
    {
        temp = q.peek();
        q.remove();
        
        if(temp.key==key)
        {
            to_be_deleted = temp;
        }
        //if the left side is not null.
        if(temp.left!=null)
        {
            q.add(temp.left);
        }
        if(temp.right!=null)
        {
            q.add(temp.right);
        }
    }
    
    //now we would get the node to be deleted and the last node too..
    
    //copy the last node key at the node to be deleted position..
    
    if(to_be_deleted!=null)//means a node which we have to delete is there..
    {
        int x = temp.key;
        deleteDeepest(root,temp);  //this will remove the deepest node.
        to_be_deleted.key = x;
    }
}
 
// Driver code
public static void main(String args[])
{
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.left.right = new Node(12);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);
 
    System.out.print("Inorder traversal " +
                     "before deletion:");
    inorder(root);
 
    int key = 11;
    delete(root, key);
 
    System.out.print("\nInorder traversal " +
                     "after deletion:");
    inorder(root);
}
}
