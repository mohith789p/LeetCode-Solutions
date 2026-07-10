class Solution {
    public int maxSubarraySumCircular(int[] nums) {
         int total = 0;
         int max = nums[0], curMax = 0;
         int min = nums[0], curMin = 0;

         for(int num : nums){
            total += num;
            curMax = Math.max(num, curMax + num);
            max = Math.max(max,curMax);
            curMin = Math.min(num, curMin + num);
            min = Math.min(min,curMin);
         }

         if(max < 0) return max;

         return Math.max(max, total - min);
    }
}