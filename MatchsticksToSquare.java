import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MatchsticksToSquare {
    public List<Integer> nums;
    public int[] sides;
    public int sideLen;

    public MatchsticksToSquare() {
        sides = new int[4];
        nums = new ArrayList<>();
    }

    public boolean makeSquare(int[] matchsticks) {
        int sum = 0;
        for (int n : matchsticks)
            sum += n;

        if (sum % 4 != 0)
            return false;

        sideLen = sum / 4;

        nums = Arrays.stream(matchsticks).boxed().collect(Collectors.toList());
        Collections.sort(nums, Collections.reverseOrder());

        return backtrack(0);
    }

    private boolean backtrack(int i) {
        if (i == nums.size())
            return true;

        for (int j = 0; j < 4; j++) {
            if (sides[j] + nums.get(i) <= sideLen) {
                sides[j] += nums.get(i);
                if (backtrack(i + 1))
                    return true;
                sides[j] -= nums.get(i);
            }
        }

        return false;
    }
}
