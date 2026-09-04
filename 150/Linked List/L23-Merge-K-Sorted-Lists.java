/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if(n==0)
        {
            return null;
        }
        ListNode node=lists[0];
        for(int i=1;i<n;i++)
        {
            node=mergeTwoLists(node,lists[i]);
        }
        return node;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp=new ListNode(0);
        ListNode current=temp;
        while (list1!=null&&list2!=null) {
            if (list1.val<=list2.val) {
                current.next=list1;
                list1=list1.next;
            } else {
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }
        if (list1!=null) {
            current.next=list1;
        } else {
            current.next=list2;
        }
        return temp.next;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        ListNode a=new ListNode(1);
        a.next=new ListNode(4);
        a.next.next=new ListNode(5);
        ListNode b=new ListNode(1);
        b.next=new ListNode(3);
        b.next.next=new ListNode(4);
        ListNode c=new ListNode(2);
        c.next=new ListNode(6);
        ListNode[] lists={a,b,c};
        ListNode result=s.mergeKLists(lists);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
}