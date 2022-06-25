public class SortColors {
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int start = 0, end = nums.length - 1;
        for (int i = start; i <= end;) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, end);
                end--;
            } else
                i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
