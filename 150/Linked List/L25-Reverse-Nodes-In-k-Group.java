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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        int ptr=0;
        while(ptr<k&&curr!=null)
        {
            curr=curr.next;
            ptr++;
        }
        if(ptr==k)
        {
            curr=reverseKGroup(curr,k);
            while(ptr-- >0)
            {
                ListNode temp=head.next;
                head.next=curr;
                curr=head;
                head=temp;
            }
            head=curr;
        }
        return head;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        int k=2;
        ListNode result=s.reverseKGroup(head,k);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
}
class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val=val;
    }
}