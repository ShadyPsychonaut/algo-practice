import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    // O(n) time and O(n) space
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head))
                return head;

            visited.add(head);
            head = head.next;
        }
        return null;
    }

    // O(n) time and O(1) space
    public ListNode detectCycleFloyd(ListNode head) {
        ListNode fast = head;
        ListNode slow1 = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow1 = slow1.next;

            if (fast == slow1) {
                ListNode slow2 = head;
                while (slow1 != slow2) {
                    slow1 = slow1.next;
                    slow2 = slow2.next;
                }
                return slow1;
            }
        }
        return null;
    }
}
