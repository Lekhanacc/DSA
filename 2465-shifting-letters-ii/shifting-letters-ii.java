class Solution {
    public String shiftingLetters(String s, int[][] shifts) {

        int n = s.length();
        int[] diff = new int[n + 1];

        // 1. Store all range operations
        for (int[] shift : shifts) {

            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                // Forward
                diff[start] += 1;
                diff[end + 1] -= 1;
            } else {
                // Backward
                diff[start] -= 1;
                diff[end + 1] += 1;
            }
        }

        // 2. Apply prefix sum + shift characters
        char[] chars = s.toCharArray();

        int currentShift = 0;

        for (int i = 0; i < n; i++) {

            currentShift += diff[i];

            currentShift %= 26;

            if (currentShift < 0) {
                currentShift += 26;
            }

            chars[i] = (char) (
                'a' + (chars[i] - 'a' + currentShift) % 26
            );
        }

        return new String(chars);
    }
}