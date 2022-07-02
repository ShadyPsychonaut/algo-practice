import java.util.Stack;

public class LongestValidParenthesis {
    public int longestValidParenthesis(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.add(i);
            else {
                stack.pop();
                if (stack.empty())
                    stack.add(i);
                else
                    maxLen = Math.max(maxLen, i - stack.peek());
            }
        }

        return maxLen;
    }
}
