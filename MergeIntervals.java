import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0])
                merged.add(interval);
            else
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public void print(int[][] a) {
        for (int[] row : a) {
            System.out.print("[ ");
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        MergeIntervals merge = new MergeIntervals();
        merge.print(merge.merge(intervals));
    }
}
