class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // If mid element is greater than right element,
            // minimum lies in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // Otherwise minimum lies in left half (including mid)
            else {
                right = mid;
            }
        }

        // left == right will point to minimum
        return nums[left];
    }
}
