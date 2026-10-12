class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int row, int col,
                     int originalColor, int color) {

        int n = image.length;
        int m = image[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m ||
            image[row][col] != originalColor) {
            return;
        }

        image[row][col] = color;

        dfs(image, row - 1, col, originalColor, color); // Up
        dfs(image, row + 1, col, originalColor, color); // Down
        dfs(image, row, col - 1, originalColor, color); // Left
        dfs(image, row, col + 1, originalColor, color); // Right
    }
}