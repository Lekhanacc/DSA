public class Solution {
    // Treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift the result left to make room for the next bit
            result <<= 1;
            // Get the last bit of n and add it to the result
            result |= (n & 1);
            // Shift n right logically to process the next bit
            n >>>= 1;
        }
        return result;
    }
}
