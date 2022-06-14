public class MaxSubarray {
    public int maxSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int prev = nums[0];
        int max = prev;
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(nums[i], prev + nums[i]);
            max = Math.max(max, prev);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] arr2 = { -2, -5, -3, -6 };
        MaxSubarray m = new MaxSubarray();
        System.out.println(m.maxSubarray(arr1)); // should output 6
        System.out.println(m.maxSubarray(arr2)); // should output -2
    }
}
