/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        dfsS(root,sb);
        return sb.toString();
    }
    public void dfsS(TreeNode root, StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        dfsS(root.left,sb);
        dfsS(root.right,sb);
    }
    public TreeNode deserialize(String data) {
       String[] nodes=data.split(",");
       int[] index={0};
       return dfsD(nodes,index);
    }
    public TreeNode dfsD(String[] nodes,int[] index)
    {
         String value=nodes[index[0]];
         index[0]++;
         if(value.equals("N"))
         {
            return null;
         }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = dfsD(nodes, index);
        root.right = dfsD(nodes, index);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println("Serialized:");
        System.out.println(data);

        TreeNode newRoot = codec.deserialize(data);

        System.out.println("\nDeserialized tree (preorder):");
        printPreorder(newRoot);
    }
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));