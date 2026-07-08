class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        Map<Integer, Integer> mp = new HashMap<>();

        int curr = 0;
        mp.put(0, 1);

        for(int num : nums){
            curr += num;

            if(mp.get(curr - k) != null){
                count += mp.get(curr - k);
            }

            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
        }

        return count;
    }
}