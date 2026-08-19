class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int count = 0, max = 0;

        for(int i = 0; i < nums.length; i++){
            count += (nums[i] == 0) ? 1 : -1;

            if(mp.containsKey(count)){
                max = Math.max(max, i - mp.get(count));
            } else {
                mp.put(count, i);
            }
        }

        return max;
    }
}