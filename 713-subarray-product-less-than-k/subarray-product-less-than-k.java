class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1;
        int st = 0, end = 0;
        int count = 0;

        for(end = 0; end < nums.length; end++){
            prod *= nums[end];

            while(prod >= k){
                prod /= nums[st++];
            }

            count+= end - st + 1;
        }

        return count;
    }
}