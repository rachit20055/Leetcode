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
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return same(p,q);
    }
    public boolean same(TreeNode p,TreeNode q)
    {
        if(p==null&&q==null)
        {
            return true;
        }
        if(p==null||q==null)
        {
            return false;
        }
        if(p.val!=q.val)
        {
            return false;
        }
        else 
            return same(p.left,q.left)&&same(p.right,q.right);
    }
    public static void main(String[] args) {
        TreeNode p=new TreeNode(1);
        p.left=new TreeNode(2);
        p.right=new TreeNode(3);
        TreeNode q=new TreeNode(1);
        q.left=new TreeNode(2);
        q.right=new TreeNode(3);
        Solution sol=new Solution();
        boolean result=sol.isSameTree(p, q);
        System.out.println(result);
    }
}