class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = getMax(piles);

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                high = mid; // try smaller speed
            } else {
                low = mid + 1; // need bigger speed
            }
        }

        return low;
    }

    // Helper to check if Koko can finish eating at speed k
    private boolean canFinish(int[] piles, int h, int k) {

        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil(pile / k)
        }

        return hours <= h;
    }

    // Helper to find maximum pile
    private int getMax(int[] piles) {

        int max = piles[0];

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        return max;
    }
}
