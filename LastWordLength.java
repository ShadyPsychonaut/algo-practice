class LastWordLength {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ')
                return s.length() - (i + 1);
        }
        return s.length();
    }
}