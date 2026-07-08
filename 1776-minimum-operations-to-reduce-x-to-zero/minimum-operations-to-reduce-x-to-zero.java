class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int target = -x;
        for(int num : nums) target += num;
        
        int max = -1, sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];

            mp.putIfAbsent(sum, i);
            
            if(mp.containsKey(sum - target)){
                max = Math.max(max,i - mp.get(sum - target));
            }
        }

        return max == -1 ? -1 : n - max;
    }
}