class MinimumSizeSubarray {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (sum < target && right < nums.length) {
            sum += nums[right];

            while (left < nums.length && sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
