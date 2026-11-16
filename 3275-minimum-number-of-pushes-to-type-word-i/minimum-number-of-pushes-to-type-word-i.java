class Solution {
    public int minimumPushes(String word) {
        int totalPushes = 0;
        int n = word.length();
        
        for (int i = 0; i < n; i++) {
            // Every 8 distinct letters, the required pushes per letter increases by 1
            totalPushes += (i / 8) + 1;
        }
        
        return totalPushes;
    }
}