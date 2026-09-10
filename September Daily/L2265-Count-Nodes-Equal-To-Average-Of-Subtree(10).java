class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
   TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
          this.right = right;
     }
}
class Solution {
    int res;
    public int averageOfSubtree(TreeNode root) {
        res=0;
        dfs(root);
        return res;
    }
    public int[] dfs(TreeNode root)
    {
        if(root==null)
        {
            return new int[]{0,0};
        }
        int left[]=dfs(root.left);
        int right[]=dfs(root.right);
        int sum=root.val+left[1]+right[1];
        int count=1+left[0]+right[0];
        if(root.val==(sum)/count)
        {
            res++;
        }
        return new int[]{count,sum};
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(8);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(1);
        root.right.right=new TreeNode(6);
        Solution sol=new Solution();
        System.out.println(sol.averageOfSubtree(root));
    }
}