class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        long requiredFlowers = (long)m * k;

        // Not enough flowers
        if (requiredFlowers > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // find search range
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;   // try smaller day
            } else {
                low = mid + 1;    // need more days
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int day, int m, int k) {

        int bouquets = 0;
        int count = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                count++;

                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }

        return bouquets >= m;
    }
}