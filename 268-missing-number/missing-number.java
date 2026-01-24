import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        // If all indices matched
        return nums.length;
    }
}


// class Solution {
//     public int missingNumber(int[] arr) {
//         int n = arr.length;
//         int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
//         int actualSum = 0;

//         for (int num : arr) {
//             actualSum += num;
//         }

//         return expectedSum - actualSum;
//     }
// }
