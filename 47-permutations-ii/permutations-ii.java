class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        backTrack(nums, 0, ans);
        return ans;
    }

    private void backTrack(int[] nums, int i, List<List<Integer>> res){
        if(i == nums.length){
            List<Integer> cur = new ArrayList<>();
            for(int num : nums){
                cur.add(num);
            }
            res.add(cur);
            return;
        }
        Set<Integer> seen = new HashSet<>();

        for(int j = i; j < nums.length; j++){
            if(seen.contains(nums[j])) continue;
            
            seen.add(nums[j]);
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