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
        if(lists==null||lists.length==0){
            return null;
        }
        int interval=1;
        while(interval<lists.length){
            for(int i=0;i+interval<lists.length;i+=interval*2){
                lists[i]=mergeTwoLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }
    public ListNode mergeTwoLists(ListNode list1,ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        if(list1!=null){
            curr.next=list1;
        }else{
            curr.next=list2;
        }
        return dummy.next;
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