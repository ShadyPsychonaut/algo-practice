import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfArrays {

    // O(m + n) time, O(min(m,n)) space
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        int[] ans = new int[Math.min(nums1.length, nums2.length)];

        int c = 0;
        for (int num : nums2) {
            if (map.isEmpty())
                break;
            if (map.containsKey(num)) {
                ans[c++] = num;
                int count = map.get(num);
                map.replace(num, --count);
                if (count == 0)
                    map.remove(num);
            }
        }
        return Arrays.copyOf(ans, c);
    }

    // Sort then two pointers, O(mlogm + nlogn) time, O(sorting) space
    public int[] intersectUsingSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int i = 0, j = 0, c = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                ans[c++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(ans, c);
    }
}
