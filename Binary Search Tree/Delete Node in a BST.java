/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    //the function which will be called from the main function.
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        root=deleteKey(root,key); //this will return the root node..
        return root;
    }
    
    //recursive function to delete the node
    public TreeNode deleteKey(TreeNode root,int key)
    {
        //base condition
        if(root==null)
        {
            return null;
        }
        
        //now will be checking if the node is present on the left side or the right side..
        
        //left side.
        if(key<root.val)
        {
            root.left = deleteKey(root.left,key);
        }
        //right side.
        else if(key>root.val)
        {
            root.right = deleteKey(root.right,key);
        }
        
        //if key is same to the roots key.(key==root.data)
        else
        {
            //only one child
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            
            //now means two children are there..
            
            //find the inorder successor of the root node(will be on the right side (smallest))
            //updated the value of the root node..
            root.val = minValue(root.right);
            
            //now deleting the inorder successor.
            root.right = deleteKey(root.right,root.val);
        }
        return root;
    }
    
    //this function will find the inorder successor of the root node.
    public int minValue(TreeNode root)
    {
        int mv = root.val;//min value
        while(root.left!=null)  //go the end of the left side
        {
            mv = root.left.val;
            root=root.left;
        }
        return mv;
    }
}
