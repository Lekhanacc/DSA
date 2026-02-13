class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2, 5, 6, 0, 0, 1, 2}; // Rotated array with duplicates
        int target = 0;
        System.out.println(sol.search(nums, target)); // Expected output: true
    }
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates by incrementing start
            while (start < mid && nums[start] == nums[mid]) {
                start++;
            }

            // Check if the left half is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1; // Search left half
                } else {
                    start = mid + 1; // Search right half
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1; // Search right half
                } else {
                    end = mid - 1; // Search left half
                }
            }
        }
        return false; // Target not found
    }
}  