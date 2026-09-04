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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode l1=new ListNode(0);
        l1.next=head;
        ListNode l2=l1;
        ListNode l3=l1;
        for(int i=0;i<=n;i++) {
            l3=l3.next;
        }
        while(l3!=null) {
            l2=l2.next;
            l3=l3.next;
        }
        l2.next=l2.next.next;
        return l1.next;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        int n=2;
        ListNode result=s.removeNthFromEnd(head,n);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
}