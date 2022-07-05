public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int res = num / mid, rem = num % mid;
            if (rem == 0 && res == mid)
                return true;
            if (res < mid)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
}
