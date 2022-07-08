class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            if (num > max)
                max = num;
        }

        int l = max, r = sum;
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canSplit(mid, nums, m)) {
                res = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }

        return res;
    }

    private boolean canSplit(int largest, int[] nums, int m) {
        int subarray = 0;
        int curSum = 0;

        for (int num : nums) {
            curSum += num;
            if (curSum > largest) {
                subarray++;
                curSum = num;
            }
        }
        return subarray + 1 <= m;
    }
}

// Time: O(N * log(sum of all elements))
// Space: O(1)