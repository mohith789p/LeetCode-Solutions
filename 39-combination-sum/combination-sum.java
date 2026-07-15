class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        backtrack(candidates, target, 0, sub, ans);
        return ans;
    }

    private void backtrack(int[] arr, int t, int i, List<Integer> sub, List<List<Integer>> res){
        if(t == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }

        if(t < 0 || i == arr.length) return;
        
        for(int j = i; j < arr.length; j++){
            sub.add(arr[j]);
            backtrack(arr, t - arr[j], j, sub, res);
            sub.remove(sub.size() - 1);
        }
    }
}