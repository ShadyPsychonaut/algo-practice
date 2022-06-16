public class AddTwoListUsingCarry {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp1 = l1, temp2 = l2, curr = head;
        int sum, carry = 0;

        while (temp1 != null || temp2 != null) {
            sum = carry;
            sum += (temp1 != null) ? temp1.val : 0;
            sum += (temp2 != null) ? temp2.val : 0;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }

        if (carry > 0)
            curr.next = new ListNode(carry);

        return head.next;
    }
}
