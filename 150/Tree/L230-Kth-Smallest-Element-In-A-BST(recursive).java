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
    int count=0;
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }
    public void inorder(TreeNode root, int k) {
        if (root==null) {
            return;
        }
        inorder(root.left, k);
        count++;
        if(count==k) {
            answer=root.val;
            return;
        }
        inorder(root.right, k);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        int k = 3;
        Solution sol = new Solution();
        int result = sol.kthSmallest(root, k);
        System.out.println("K = " + k);
        System.out.println("Kth smallest = " + result);
    }
}