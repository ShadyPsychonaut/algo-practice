class Palindrome {
    public boolean isPalindrome(int x) {

        String input = String.valueOf(x);
        String revInput = "";
        char ch;

        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            revInput = ch + revInput;
        }

        return input.equals(revInput);
    }

    public boolean isPalindromeInt(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int revertedNum = 0;
        while (x > revertedNum) {
            revertedNum = revertedNum * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNum || x == revertedNum / 10;

    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(123));
    }
}