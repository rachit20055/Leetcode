
import java.util.Arrays;

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
    public TreeNode buildTree(int[] p, int[] in) {
          if(p.length==0||in.length==0)
          {
            return null;
          }
          TreeNode root=new TreeNode(p[0]);
          int j=0;
          while(in[j]!=root.val)
          {
              j++;
          }
          int[] leftin=Arrays.copyOfRange(in, 0, j);
          int[] rightin=Arrays.copyOfRange(in,j+1,in.length);
          int[] leftpre=Arrays.copyOfRange(p, 1, 1+j);
          int[] rightpre=Arrays.copyOfRange(p,j+1,p.length);
          root.left=buildTree(leftpre,leftin);
          root.right=buildTree(rightpre,rightin);
          return root;
    }
    public void printInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
    public void printPreorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution sol = new Solution();
        TreeNode root = sol.buildTree(preorder, inorder);
        System.out.print("Preorder: ");
        sol.printPreorder(root);
        System.out.println();
        System.out.print("Inorder: ");
        sol.printInorder(root);
        System.out.println();
    }
}