class Solution {
    public void moveZeroes(int[] nums) {

        for(int i = 0, j = 0; i < nums.length;i++){
              while(j < nums.length && nums[j] != 0){
                j++;
              }

              if(nums[i] != 0 && j < i){
                nums[j] = nums[i];
                nums[i] = 0;
              }
        }
    }
}