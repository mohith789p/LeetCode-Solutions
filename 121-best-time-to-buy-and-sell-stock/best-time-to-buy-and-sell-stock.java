class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0]; // min
        int sell = prices[0]; // max
        int ans = 0;
        for(int i = 1; i < prices.length; i++){
            if(buy > prices[i]){
                buy = prices[i];
                sell = prices[i];
            } else {
                if(sell < prices[i]){
                    sell = prices[i];
                }
            }
            ans = Math.max(ans, sell - buy);
        }

        return ans;
    }
}