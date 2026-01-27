class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {

            // If the current element is 1, increment the count
            if (nums[i] == 1) {
                cnt++;

                // Update maxi if current count is greater than maxi
                maxi = Math.max(maxi, cnt);

            } else {
                // If the current element is 0, reset the count
                cnt = 0;
            }
        }
        return maxi;
    }
}