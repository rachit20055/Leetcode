class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode l1=head;
        ListNode l2=head;
        while(l2!=null&&l2.next!=null) {
            l1=l1.next;
            l2=l2.next.next;
            if(l1==l2) {
                return true;
            }
        }
        return false;
    }
    static ListNode createList(int... values) {
        if (values.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }
    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("===== Linked List Cycle =====");
        ListNode head = createList(3, 2, 0, -4);
        ListNode second = head.next;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = second;
        Solution solution = new Solution();
        boolean result = solution.hasCycle(head);
        System.out.println("Has Cycle: " + result);
        System.out.println();
    }
}