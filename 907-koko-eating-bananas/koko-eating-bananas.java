class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1;
        int high = 0;
        
        // Find maximum pile
        for(int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int ans = high;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            long hours = 0;
            
            for(int pile : piles) {
                hours += (pile + mid - 1) / mid;  // ceil division
            }
            
            if(hours <= h) {
                ans = mid;        // possible answer
                high = mid - 1;   // try smaller speed
            } else {
                low = mid + 1;    // increase speed
            }
        }
        
        return ans;
    }
}


