class RotatedArraySearch {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                    while (left < nums.length && nums[left] == nums[left - 1])
                        left++;
                } else {
                    right = mid - 1;
                    while (right >= 0 && nums[right] == nums[right + 1])
                        right--;
                }
            } else if (nums[mid] == nums[left] && nums[left] == nums[right]) {
                while (left < nums.length - 1 && nums[left] == nums[left + 1])
                    left++;
                while (right > 0 && nums[right] == nums[right - 1])
                    right--;
                left++;
                right--;
            } else {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                    while (right >= 0 && nums[right] == nums[right + 1])
                        right--;
                } else {
                    left = mid + 1;
                    while (left < nums.length && nums[left] == nums[left - 1])
                        left++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 1 };
        RotatedArraySearch s = new RotatedArraySearch();
        System.out.println(s.search(nums, 0));
    }
}
