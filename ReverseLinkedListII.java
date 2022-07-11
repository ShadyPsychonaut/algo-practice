public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel;
        ListNode cur = head;

        for (int i = 1; i < left; i++) {
            prev = cur;
            cur = cur.next;
        }

        ListNode leftPrev = prev;
        ListNode tail = cur;
        prev = null;

        for (int i = 1; i <= right - left + 1; i++) {
            ListNode succ = cur.next;
            cur.next = prev;
            prev = cur;
            cur = succ;
        }

        tail.next = cur;
        leftPrev.next = prev;

        return sentinel.next;
    }
}
