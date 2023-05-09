public class MaxProfit {
    /*
     * Using find min algorithm for lowest price, while simultaniously
     * using find max to calculate the max profit.
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice)
                minPrice = prices[i];
            int currentProfit = prices[i] - minPrice;
            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
            }    
        }
        return maxProfit;
    }
}
