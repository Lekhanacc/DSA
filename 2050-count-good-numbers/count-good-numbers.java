class Solution {

    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {

        long even = (n + 1) / 2;
        long odd = n / 2;

        long part1 = power(5, even);
        long part2 = power(4, odd);

        return (int)((part1 * part2) % MOD);
    }

    private long power(long base, long exponent) {

        long result = 1;

        while (exponent > 0) {

            // If exponent is odd
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;

            exponent = exponent / 2;
        }

        return result;
    }
}