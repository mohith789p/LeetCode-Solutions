class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = i; j >= 0; j--){
               if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] +=1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}