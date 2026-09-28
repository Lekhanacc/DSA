class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long result = 0;

        while (a >= b) {

            long value = b;
            long count = 1;

            while (a >= (value << 1)) {
                value = value << 1;
                count = count << 1;
            }

            a = a - value;
            result = result + count;
        }

        if (negative) {
            result = -result;
        }

        return (int) result;
    }
}