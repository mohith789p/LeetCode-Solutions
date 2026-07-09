class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        backTrack(nums, 0, ans);
        return new ArrayList<>(ans);
    }

    private void backTrack(int[] nums, int i, Set<List<Integer>> res){
        if(i == nums.length){
            List<Integer> cur = new ArrayList<>();
            for(int num : nums){
                cur.add(num);
            }
            res.add(cur);
            return;
        }

        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            backTrack(nums, i + 1, res);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}