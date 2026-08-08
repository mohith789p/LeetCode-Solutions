class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length, idx = n - 1;

        int dp[] = new int[n];

        dp[idx] = cost[idx--];
        dp[idx] = cost[idx];
        
        while(--idx >= 0){
            dp[idx] = cost[idx] + Math.min(dp[idx + 1], dp[idx + 2]);
        }

        return Math.min(dp[0], dp[1]);
    }
}