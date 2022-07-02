public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        int n = nums.length;

        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums, nums[i] - 1, i);
            else
                i++;
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != (i + 1))
                return i + 1;
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
