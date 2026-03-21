class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int ans = 0;
        for(int price : prices){
            if(buy > price){
                buy = price;
            }
            ans = Math.max(ans, price - buy);
        }

        return ans;
    }
}