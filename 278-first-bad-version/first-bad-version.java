/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      // binary search

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            // Avoid potential integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // mid is bad, so the first bad version is at mid or to its left
                right = mid;
            } else {
                // mid is good, so the first bad version must be strictly to its right
                left = mid + 1;
            }
        }
        
        // When left == right, we have found the first bad version
        return left;
    }
}
