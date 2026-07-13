class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int count = 1;

        for(int i = 1;  i < n; i++){
            if(nums[i] != nums[i - 1]){
                nums[count++] = nums[i];
            }
        }

        int max = 0;
        int j = 0;

        for(int i = 0; i < count; i++){
            while(j < count && nums[j] <= nums[i] + n - 1){
                j++;
            }

            max = Math.max(max, j - i);
        }

        return n - max;
    }
}