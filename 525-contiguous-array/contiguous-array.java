class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        int curr = 0;
        mp.put(0, -1);

        int max = 0;

        for(int i = 0; i < n; i++){
            int num = (nums[i] == 0) ? -1 : 1;
            curr += num;
            
            if(mp.containsKey(curr)){
                max = Math.max(max,i - mp.get(curr));
            } else {
                mp.put(curr, i);
            }
        }

        return max;
    }
}