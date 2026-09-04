
import java.util.ArrayList;
import java.util.List;

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
    public void reorderList(ListNode head) {
        List<Integer> a=new ArrayList<>();
        ListNode node=head; 
        while(node!=null)
        {
             a.add(node.val);
             node=node.next;
        }
        int i=0;
        int j=a.size()-1;
        while(i<=j)
        {
            if(head==null)
            {
                break;
            }
            if(i==j)
            {
                head.val=a.get(i);
                i++;
                j--;
            }
            else
            {
                head.val=a.get(i);
                head=head.next;
                i++;
                if(head!=null)
                {
                    head.val=a.get(j);
                    head=head.next;
                    j--;
                }
            }
        }

        
    }
    public static void main(String[] args){
        Solution s=new Solution();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        s.reorderList(head);
        ListNode curr=head;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
    }
}