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
    public int goodNodes(TreeNode root) {
        return nodes(root,root.val);
    }
    public int nodes(TreeNode root, int max)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.val<max)
        {
            return nodes(root.left,max)+nodes(root.right,max);
        }
        else
            return 1+nodes(root.left,root.val)+nodes(root.right,root.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left=new TreeNode(1);
        Solution sol = new Solution();
        int result=sol.goodNodes(root);
        System.out.println(result);
    }
}