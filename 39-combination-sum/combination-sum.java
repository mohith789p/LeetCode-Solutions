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

        for(int j = i; j < arr.length; j++){
            if(sum > k) continue;

            sub.add(arr[j]);
            back(arr, k, j, sum + arr[j], sub, res);
            sub.remove(sub.size() -1);
        }
    }
}