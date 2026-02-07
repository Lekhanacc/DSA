import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Result list to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 3: Add first interval
        result.add(intervals[0]);

        // Step 4: Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] last = result.get(result.size() - 1);
            int[] current = intervals[i];

            // Step 5: Check overlap
            if (current[0] <= last[1]) {

                // Merge by updating end
                last[1] = Math.max(last[1], current[1]);

            } else {

                // No overlap → add interval
                result.add(current);
            }
        }

        // Convert list to array
        return result.toArray(new int[result.size()][]);
    }
}
