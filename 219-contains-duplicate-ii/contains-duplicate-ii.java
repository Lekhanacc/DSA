import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Keep the window size at most k
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            // If add() returns false, a duplicate exists within distance k
            if (!window.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
