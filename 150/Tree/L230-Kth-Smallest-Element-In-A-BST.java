
import java.util.Stack;

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
    public int kthSmallest(TreeNode root, int k) {
        int n=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while(curr!=null||!stack.isEmpty())
        {
            while(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            n++;
            if(n==k)
            {
                return curr.val;
            }
            curr=curr.right;
        }
        return k;
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