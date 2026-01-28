class Solution {
    public int maxSubArray(int[] nums) {

        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {

            // either start new subarray or extend old one
            currSum = Math.max(nums[i], currSum + nums[i]);

            // update maximum sum
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}