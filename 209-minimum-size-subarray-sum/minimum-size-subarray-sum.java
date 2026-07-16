class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        int st = 0, end = 0;
        for(end = 0; end < nums.length; end++){
            sum += nums[end];

            while(sum >= target){
                min = Math.min(min, end - st + 1);
                sum -= nums[st++];
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}