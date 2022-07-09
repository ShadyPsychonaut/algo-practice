import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);

        for (int i = 0; i < n; i++) {
            nums[i] = nums[dq.peekFirst()] + nums[i];

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            dq.offerLast(i);

            if (i - dq.peekFirst() >= k)
                dq.pollFirst();
        }
        return nums[n - 1];
    }
}
