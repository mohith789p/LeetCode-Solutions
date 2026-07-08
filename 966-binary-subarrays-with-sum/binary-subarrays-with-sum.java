class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    int atMost(int[] arr, int x){
        if(x < 0) return 0;

        int l = 0, sum = 0;
        int count = 0;

        for(int r = 0; r < arr.length; r++){
            sum += arr[r];

            while(sum > x && l <= r){
                sum -= arr[l++];
            }

         count += (r - l + 1);   
        }
        
        return count;
    }

}