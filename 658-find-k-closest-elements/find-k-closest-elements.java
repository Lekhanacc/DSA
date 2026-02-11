import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - 1;

        // shrink window until size becomes k
        while (right - left + 1 > k) {

            // compare distances
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;   // remove left element
            } 
            else {
                right--;  // remove right element
            }
        }

        // collect answer
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
