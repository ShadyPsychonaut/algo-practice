import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> rn = new HashMap<>();
        int num = 0;
        rn.put('I', 1);
        rn.put('V', 5);
        rn.put('X', 10);
        rn.put('L', 50);
        rn.put('C', 100);
        rn.put('D', 500);
        rn.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = (i < s.length() - 1) ? s.charAt(i + 1) : ' ';

            if (ch2 != ' ' && rn.get(ch2) > rn.get(ch1)) {
                num += rn.get(ch2) - rn.get(ch1);
                i++;
            } else
                num += rn.get(ch1);
        }

        return num;
    }

    public static void main(String args[]) {
        RomanToInt solver = new RomanToInt();
        System.out.println(solver.romanToInt("MMMCMXCIX"));
    }
}
