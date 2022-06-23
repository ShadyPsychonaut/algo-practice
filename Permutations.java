import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 0)
            return res;

        backtrack(nums, res, new ArrayList<>());

        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list) {

        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            backtrack(nums, result, list);
            list.remove(list.size() - 1);
        }
    }
}
