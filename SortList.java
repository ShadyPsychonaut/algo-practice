import java.util.Comparator;
import java.util.PriorityQueue;

public class SortList {
    // Using PQ, O(N * log N) time, O(N) space
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });

        ListNode temp = head;
        while (temp != null) {
            pq.offer(temp);
            temp = temp.next;
        }

        ListNode sentinel = new ListNode(0, head);
        head = sentinel;
        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;
        }

        head.next = null;

        return sentinel.next;
    }

    // O(N * log N) time and O(log N) space complexity
    public ListNode sortListMergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode left = head;
        ListNode right = getMid(head);
        ListNode temp = right.next;
        right.next = null;
        right = temp;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sentinel, tail;
        sentinel = tail = new ListNode();

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null)
            tail.next = l1;

        if (l2 != null)
            tail.next = l2;

        return sentinel.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow, fast;
        slow = head;
        fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
