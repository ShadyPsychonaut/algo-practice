import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), target, candidates, 0);
        return res;

    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int target, int[] candidates, int start) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrack(res, list, target - candidates[i], candidates, i);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5 };
        CombinationSum sum = new CombinationSum();
        List<List<Integer>> list = sum.combinationSum(arr, 8);
        System.out.println(list);
    }
}
