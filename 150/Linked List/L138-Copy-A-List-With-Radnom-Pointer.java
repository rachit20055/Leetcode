/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
import java.util.HashMap;
class Solution {
    HashMap<RandomNode,RandomNode> map=new HashMap<>();
    public RandomNode copyRandomList(RandomNode head) {
        if(head==null)
        {
            return null;
        }
        if(map.containsKey(head))
        {
            return map.get(head);
        }
        RandomNode node=new RandomNode(head.val);
        map.put(head,node);
        node.next=copyRandomList(head.next);
        node.random=map.get(head.random);
        return node;
    }
    public static void main(String[] args) {
        RandomNode node1 = new RandomNode(7);
        RandomNode node2 = new RandomNode(13);
        RandomNode node3 = new RandomNode(11);
        RandomNode node4 = new RandomNode(10);
        RandomNode node5 = new RandomNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        Solution solution=new Solution();
        RandomNode copy =solution.copyRandomList(node1);
        printList(copy);
    }
    static void printList(RandomNode head) {
        while(head!=null) {
            System.out.print("[" + head.val +", random=" + (head.random == null ? "null": head.random.val) + "]" );
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}