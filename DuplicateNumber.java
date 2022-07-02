class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = (int) Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] = 0 - nums[cur];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] = (int) Math.abs(nums[i]);
        }
        return duplicate;
    }

    public int findDuplicatesWithoutModification(int[] nums) {
        int left = 1, right = nums.length - 1;
        int duplicate = -1;
        while (left <= right) {
            int cur = (left + right) / 2;
            int count = 0;
            for (int n : nums) {
                if (n <= cur)
                    count++;
            }
            if (count > cur) {
                duplicate = cur;
                right = cur - 1;
            } else
                left = cur + 1;
        }
        return duplicate;
    }
}

// Time: O(n)
// Space: O(1)
