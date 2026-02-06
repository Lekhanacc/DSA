class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers are not palindrome
        if (x < 0) return false;

        // Numbers ending in 0 (except 0) are not palindrome
        if (x % 10 == 0 && x != 0) return false;

        int reversedHalf = 0;

        // Reverse only half of the digits
        while (x > reversedHalf) {

            int digit = x % 10;   // last digit
            reversedHalf = reversedHalf * 10 + digit;

            x = x / 10;           // remove last digit
        }

        // For even digits: x == reversedHalf
        // For odd digits: x == reversedHalf/10
        return (x == reversedHalf || x == reversedHalf / 10);
    }
}
