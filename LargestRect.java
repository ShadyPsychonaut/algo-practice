public class LargestRect {
    public int largestRectArea(int[] heights) {
        int[] smallerFromLeft = new int[heights.length];
        int[] smallerFromRight = new int[heights.length];
        smallerFromLeft[0] = -1;
        smallerFromRight[heights.length - 1] = heights.length;

        int p, maxArea = 0;

        for (int i = 1; i < heights.length; i++) {
            p = i - 1;

            while (p >= 0 && heights[p] >= heights[i])
                p = smallerFromLeft[p];

            smallerFromLeft[i] = p;
        }

        for (int i = heights.length - 2; i >= 0; i--) {
            p = i + 1;

            while (p < heights.length && heights[p] >= heights[i])
                p = smallerFromRight[p];

            smallerFromRight[i] = p;
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (smallerFromRight[i] - smallerFromLeft[i] - 1));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights, int i, int j) {
        if (i > j)
            return findMax(heights, j, i);
        int[] minHeight = findMin(heights, i, j);
        int result = minHeight[0] * (j - i + 1);
        if (minHeight[0] == findMax(heights, i, j))
            return result;
        int maxInHalves = Math.max(largestRectangleArea(heights, minHeight[1] + 1, j),
                largestRectangleArea(heights, i, minHeight[1] - 1));
        result = Math.max(result, maxInHalves);

        return result;
    }

    private int[] findMin(int[] a, int start, int end) {
        int min = a[start], pos = start;
        for (int i = start + 1; i <= end; i++) {
            if (a[i] < min) {
                min = a[i];
                pos = i;
            }
        }
        return new int[] { min, pos };
    }

    private int findMax(int[] a, int start, int end) {
        int max = start < 0 ? a[end] : a[start];
        for (int i = start + 1; i <= end; i++) {
            if (i >= a.length)
                return max;
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 };
        LargestRect s = new LargestRect();
        System.out.println(s.largestRectangleArea(a, 0, a.length - 1));
        System.out.println(s.largestRectArea(a));
    }
}
