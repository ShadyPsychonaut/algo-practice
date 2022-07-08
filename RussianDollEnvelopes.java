import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new EnvelopeComparator());

        List<Integer> piles = new ArrayList<>();
        for (int row = 0; row < envelopes.length; row++) {
            int num = envelopes[row][1];
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0)
                pile = ~pile;

            if (pile != piles.size())
                piles.set(pile, num);
            else
                piles.add(num);
        }

        return piles.size();
    }

    class EnvelopeComparator implements Comparator<int[]> {
        public int compare(int[] e1, int[] e2) {
            return e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0];
        }
    }
}
