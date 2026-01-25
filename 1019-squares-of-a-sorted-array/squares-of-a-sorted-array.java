class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int l = 0;
        int r = n - 1;
        int idx = n - 1;

        while (l <= r) {
            int leftSq = nums[l] * nums[l];
            int rightSq = nums[r] * nums[r];

            if (leftSq > rightSq) {
                ans[idx] = leftSq;
                l++;
            } else {
                ans[idx] = rightSq;
                r--;
            }
            idx--;
        }
        return ans;
    }
}
