import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // O(n * log n) using sort
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        Arrays.sort(nums);

        int i = 0, maxLen = 0;
        while (i < nums.length - 1) {
            int len = 1;
            while (i < nums.length - 1 && nums[i + 1] == nums[i])
                i++;
            while (i < nums.length - 1 && nums[i + 1] == nums[i] + 1) {
                len++;
                i++;
                while (i < nums.length - 1 && nums[i + 1] == nums[i])
                    i++;
            }

            maxLen = Math.max(maxLen, len);
            i++;
        }
        return maxLen;
    }

    // O(n) time using HashSet
    public int longestConsecutiveUsingSets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int maxLen = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;

                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }

                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
