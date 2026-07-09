class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        back(n, k, 1, ans, sub);

        return ans;
    }

    private void back(int n, int k, int i, List<List<Integer>> ans, List<Integer> sub){

        if(sub.size() == k){
            ans.add(new ArrayList<>(sub));
            return;
        }

        for(int j = i; j <= n; j++){
            sub.add(j);
            back(n, k, j + 1, ans, sub);
            sub.remove(sub.size() -1);
        }
    }
}