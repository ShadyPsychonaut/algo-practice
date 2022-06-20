import java.util.ArrayList;
import java.util.List;

public class ParenthesisGenerator {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, new StringBuilder(), 0, 0);
        return res;
    }

    public void backtrack(List<String> res, int n, StringBuilder sb, int open, int close) {

        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            backtrack(res, n, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open > close) {
            sb.append(')');
            backtrack(res, n, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        ParenthesisGenerator generator = new ParenthesisGenerator();
        System.out.println(generator.generateParenthesis(3));
    }
}