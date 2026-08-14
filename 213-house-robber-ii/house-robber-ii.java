class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));
    }

    public int getMax(int[] arr, int st, int end){
        int rob = arr[st];
        int skip = Math.max(rob, arr[st + 1]);

        for(int i = st + 2; i <= end; i++){
            int cur = Math.max(skip, rob + arr[i]);
            rob = skip;
            skip = cur;
        }

        return skip;
    }
}