class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {

        int count = 0;
        int windowSize = pattern.length + 1;

        for (int start = 0; start <= nums.length - windowSize; start++) {

            boolean match = true;

            for (int j = 0; j < pattern.length; j++) {

                if (pattern[j] == 1 && nums[start + j + 1] <= nums[start + j]) {
                    match = false;
                    break;
                }

                if (pattern[j] == 0 && nums[start + j + 1] != nums[start + j]) {
                    match = false;
                    break;
                }

                if (pattern[j] == -1 && nums[start + j + 1] >= nums[start + j]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }
        }

        return count;
    }
}