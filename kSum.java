import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class kSum {
    public List<List<Integer>> k_Sum(int[] nums, int start, int k, long target) {

        List<List<Integer>> res = new ArrayList<>();

        if (start >= nums.length)
            return res;

        if (nums[start] > target / k || nums[nums.length - 1] < target / k)
            return res;

        if (k == 2)
            return twoSum(nums, target, start);

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : k_Sum(nums, i + 1, k - 1, target - nums[i])) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }
        return res;
    }
}

// Time: O(N ^ (k - 1))
// Space: O(k)