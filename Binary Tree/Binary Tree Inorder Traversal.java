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
     List<Integer> inorder = new ArrayList<>();
    
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        
        //base condtion
        if(root==null)
        {
            return inorder;
        }
        
        //now follow the path..(left->root->right).
        
        inorderTraversal(root.left);
        
        inorder.add(root.val);
        
        inorderTraversal(root.right);
        
        
        return inorder;
    }
}
