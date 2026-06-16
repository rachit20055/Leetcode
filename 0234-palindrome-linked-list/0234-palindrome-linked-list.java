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
    public boolean isPalindrome(ListNode head) {
        ListNode l1=head;
        ListNode l2=head;
        while(l2!=null&&l2.next!=null) 
        {
            l1=l1.next;
            l2=l2.next.next;
        }
        ListNode p=null;
        while(l1!=null)
         {
            ListNode n=l1.next;
            l1.next=p;
            p=l1;
            l1=n;
        }
        ListNode l3=head;
        while(p!=null) {
            if(l3.val!=p.val) {
                return false;
            }
            l3=l3.next;
            p=p.next;
        }
        return true;
    }
}