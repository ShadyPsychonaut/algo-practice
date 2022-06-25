public class JumpGameI {
    public boolean canJump(int[] nums) {

        int curFarthest = 0, curEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i >= curFarthest)
                return false;
            if (curEnd >= nums.length - 1)
                return true;
            if (i == curEnd)
                curEnd = curFarthest;

        }

        return true;
    }
}
