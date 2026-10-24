public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // Check if the last bit is 1
            count += (n & 1);
            // Unsigned right shift to process the next bit
            n >>>= 1;
        }
        return count;
    }
}
