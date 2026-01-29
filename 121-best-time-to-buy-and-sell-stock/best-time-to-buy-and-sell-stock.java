class Solution {
    public int maxProfit(int[] prices) {
        return stockBuySell(prices, prices.length);
    }

    private int stockBuySell(int[] arr, int n) {

        int minPrice = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] < minPrice) {
                minPrice = arr[i];
            } else {
                int profit = arr[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}
