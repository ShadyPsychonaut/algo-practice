import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        if (s.length() == t.length() && s.equals(t))
            return s;

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        int left = 0, right = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        // (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (right < s.length()) {
            char c = s.charAt(right);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue())
                formed++;

            while (left <= right && formed == required) {
                c = s.charAt(left);
                // Save the smallest window until now
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue())
                    formed--;

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}

// Time: O(2 * |S| + |T|)
// In the worst case we might end up visiting every element of string S twice,
// once by left pointer and once by right pointer.
//
// Space: O(|S| + |T|)
