import java.util.HashMap;
import java.util.Map;

public class JumpGame {
    public int jump(int[] nums) {

        int target = nums.length - 1;
        int minJumps = jumpUtil(nums, target, 0, new HashMap<>());

        return minJumps - 1;
    }

    private int jumpUtil(int[] nums, int target, int start, Map<Integer, Integer> memo) {

        if (memo.containsKey(target))
            return memo.get(target);
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;
        if (nums[start] == 0)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int i = nums[start]; i >= 1; i--) {
            int minJumps = jumpUtil(nums, target - i, start + i, memo);
            if (minJumps != 0 && minJumps != Integer.MAX_VALUE) {
                int totalJumps = 1 + minJumps;
                min = Math.min(min, totalJumps);
            }
        }

        memo.put(target, min);
        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 1, 4 };
        JumpGame jg = new JumpGame();
        System.out.println(jg.jump(arr)); // prints 2
    }
}
