class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int max = 0, count = 0;
        for(int m : mp.values()){
            if(max < m){
                max = m;
                count = m;
            }
            else if(m == max) count += m;
        }

        return count;
    }
}