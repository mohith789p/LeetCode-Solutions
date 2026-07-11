class Solution {
    public int maxFrequencyElements(int[] nums) {

        int[] freq = new int[101];
        int max = 0, count = 0;

        for(int i : nums){
            freq[i]++;
            if(max < freq[i]){
                max = freq[i];
                count = max;
            }
            else if(freq[i] == max) count += max;
        }

        return count;
    }
}