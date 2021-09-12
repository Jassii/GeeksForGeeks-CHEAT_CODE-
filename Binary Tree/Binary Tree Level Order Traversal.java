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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> bfs = new ArrayList<>();
        
        //base conditon
        if(root==null)
        {
            return bfs;
        }
        
        //do level order traversing of the binary tree.
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int n = q.size(); //particular size.
            List<Integer> l = new ArrayList<>(); //for particular level.
            
            while(n>0)
            {
                TreeNode temp = q.poll();
                l.add(temp.val);
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
                n--;
            }
            
            //l will be storing the node present at the particular level..
            //simply add the list 'l' in the bfs 2d list.
            bfs.add(l);
        }
        
        return bfs;
    }
}
