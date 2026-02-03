class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length < 3 || nums[0] >= nums[1])
            return false;
        
        int i = 1;
        while(i < nums.length - 1 && nums[i] < nums[i + 1]){
            i++;
        }
        if(i == nums.length - 1)
            return false;
        while(i < nums.length - 1 && nums[i] > nums[i + 1]){
            i++;
        }
        if(i == nums.length - 1)
            return false;
        while(i < nums.length - 1 && nums[i] < nums[i + 1]){
            i++;
        }
        
        return (i == nums.length - 1) ? true : false;
    }
}