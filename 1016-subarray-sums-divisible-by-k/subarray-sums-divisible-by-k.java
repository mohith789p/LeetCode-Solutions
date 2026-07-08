class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefix[] = new int[nums.length];
        
        Map<Integer, Integer> mp = new HashMap<>();

        int count = 0;
        int sum = 0;
        mp.put(0, 1);

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
            int rem = (sum % k + k) % k;

            if(mp.containsKey(rem)){
                count += mp.get(rem);
                mp.put(rem, mp.get(rem) + 1);
            } else {
                mp.put(rem, 1);
            }
        }

        return count;
    }
}