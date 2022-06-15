public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0'; // To get the integer value from ASCII value
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary solver = new AddBinary();
        System.out.println(solver.addBinary("101101", "110011")); // Should print 1100000
    }
}