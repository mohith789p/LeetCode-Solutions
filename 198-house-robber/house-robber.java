class Solution {
    public int rob(int[] nums) {
     int p = 0, c = 0;
     for(int i = 0; i < nums.length; i++){
        int t = c;
        c = Math.max(c, nums[i] + p);
        p = t;
     }
     return c;
    }
}