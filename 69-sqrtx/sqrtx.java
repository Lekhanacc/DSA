class Solution {
    public int mySqrt(int x) {
        // Base cases for 0 and 1
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {
            // Preventing potential integer overflow (equivalent to (left + right) / 2)
            int mid = left + (right - left) / 2;

            // Using division instead of (mid * mid == x) to prevent integer overflow
            if (mid == x / mid) {
                return mid;
            } 
            // If mid * mid is less than x, look in the right half
            else if (mid < x / mid) {
                ans = mid; // Update the closest integer square root found so far
                left = mid + 1;
            } 
            // If mid * mid is greater than x, look in the left half
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
}