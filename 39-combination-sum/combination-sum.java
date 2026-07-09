class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        back(candidates, target, 0, 0, sub, ans);
        return ans;
    }

    private void back(int[] arr, int k, int i, int sum, List<Integer> sub, List<List<Integer>> res){
        if(sum == k){
            res.add(new ArrayList<>(sub));
            return;
        }

        if(sum > k || i == arr.length) return;

        sub.add(arr[i]);
        back(arr, k, i, sum + arr[i], sub, res);
        sub.remove(sub.size() -1);
        back(arr, k, i + 1, sum, sub, res);
    }
}