class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int j = 1;
        int flag = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                if (flag != 1) {
                    flag++;
                    nums[j++] = nums[i];
                }
            } else {
                flag = 0;
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}