import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l1 != null) {
            sb1.insert(0, l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            sb2.insert(0, l2.val);
            l2 = l2.next;
        }
        BigInteger num1 = new BigInteger(sb1.toString());
        BigInteger num2 = new BigInteger(sb2.toString());

        BigInteger sum = num1.add(num2);
        String s = String.valueOf(sum);
        ListNode head = null;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            head = new ListNode(digit, head);
        }
        return head;
    }
    public static void main(String[] args){
        Solution s=new Solution();

        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode result=s.addTwoNumbers(l1,l2);

        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
}