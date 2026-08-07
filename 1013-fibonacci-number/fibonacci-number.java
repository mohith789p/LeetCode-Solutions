class Solution {
    static int dp[] = new int[31];

    private static void fillDP(){
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < 31; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }
    public int fib(int n) {
        if(dp[1] != 1){
            fillDP();
        }
        
        return dp[n];
    }
}