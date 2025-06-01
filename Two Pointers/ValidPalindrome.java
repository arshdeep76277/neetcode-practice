// Problem Link - https://leetcode.com/problems/valid-palindrome/

class ValidPalindrome {

    public static String getAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' & s.charAt(i) <= 'z') | (s.charAt(i) >= 'A' & s.charAt(i) <= 'Z')
                    | (Character.isDigit(s.charAt(i)))) {
                res.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return res.toString();
    }

    public boolean isPalindrome(String s) {

        String x = getAlphabets(s);
        int start = 0, end = x.length() - 1;
        while (start <= end) {
            if (x.charAt(start) != x.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;

    }
}
// Not needed when submitting solution