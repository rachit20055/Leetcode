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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    public int dfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        
        res=Math.max(root.val+left+right,res);
        return root.val+Math.max(left,right);
    }
     public static void main(String[] args) {
        TreeNode root=new TreeNode( 1, new TreeNode(2), new TreeNode(3));
        Solution solution = new Solution();
        int result = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum = " + result);
    }
}