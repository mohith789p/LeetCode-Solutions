class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, 0, subset, ans);

        return ans;
    }


    private void backTrack(int[] nums, int i, List<Integer> subset, List<List<Integer>> res){
        if(i == nums.length) {
            res.add(List.copyOf(subset));
            return;
        }

        subset.add(nums[i]);
        backTrack(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        backTrack(nums, i + 1, subset, res);
    }
}