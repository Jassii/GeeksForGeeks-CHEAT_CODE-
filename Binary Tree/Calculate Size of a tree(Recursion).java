// Size() function recursively calculates the size of a tree. It works as follows:
// Size of a tree = Size of left subtree + 1 + Size of right subtree.
// Algorithm: 
 

// size(tree)
// 1. If tree is empty then return 0
// 2. Else
//      (a) Get the size of left subtree recursively  i.e., call 
//           size( tree->left-subtree)
//      (a) Get the size of right subtree recursively  i.e., call 
//           size( tree->right-subtree)
//      (c) Calculate size of the tree as following:
//             tree_size  =  size(left-subtree) + size(right-
//                                subtree) + 1
//      (d) Return tree_size  

  
// A recursive Java program to calculate the size of the tree
class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
/* Class to find size of Binary Tree */
class BinaryTree
{
    Node root;
 
    /* Given a binary tree. Print its nodes in level order
       using array for implementing queue */
    int size()
    {
        int num = size(root);
        return num;
    }
 
    /* computes number of nodes in tree */
    int size(Node node)
    {
        if(node==null)
        {
            return 0;
        }
        int l = size(node.left);
        int r = size(node.right);
        return l+1+r;
    }
 
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        System.out.println("The size of binary tree is : "
                            + tree.size());
    }
}
