class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for(int i = 0; i <= n; i++) {

            while(!stack.isEmpty() &&
                 (i == n || heights[stack.peek()] >= heights[i])) {

                int height = heights[stack.pop()];

                int nse = i; // Next Smaller Element index

                int pse = stack.isEmpty() ? -1 : stack.peek(); // Previous Smaller Element index

                int width = nse - pse - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}