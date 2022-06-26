import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int k = 0; k <= nums.length; k++)
            backtrack(result, new ArrayList<>(), nums, 0, k);

        return result;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int start, int k) {

        if (list.size() == k) {
            res.add(new ArrayList<>(list)); // executes N times
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(res, list, nums, i + 1, k);
            list.remove(list.size() - 1);
        }
    }
}

// Time: O(N * 2^N)
// cos every element in the set has
// 2 possiblities (present or absent) and
// we create a new ArrayList N times
//
// Space: O(N) due to list which can have max N elements
