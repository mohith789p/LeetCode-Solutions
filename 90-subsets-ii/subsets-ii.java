class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        backTrack(nums, 0, subset, ans);

        return new ArrayList<>(ans);
    }


    private void backTrack(int[] nums, int i, List<Integer> subset, Set<List<Integer>> res){
        if(i == nums.length) {
            List<Integer> ans = new ArrayList<>(subset);
            Collections.sort(ans);
            res.add(ans);
            return;
        }

        subset.add(nums[i]);
        backTrack(nums, i + 1, subset, res);
        subset.remove(subset.size() - 1);
        backTrack(nums, i + 1, subset, res);
    }
}