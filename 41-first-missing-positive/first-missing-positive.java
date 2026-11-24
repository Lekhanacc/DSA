class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each positive integer x (1 <= x <= n) at index x - 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // The first index i where nums[i] != i + 1 gives the missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all integers from 1 to n are present, return n + 1
        return n + 1;
    }
}
