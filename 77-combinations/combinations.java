class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> sub = new ArrayList<>();

        back(n, k, 1, ans, sub);

        return new ArrayList<>(ans);
    }

    private void back(int n, int k, int i, Set<List<Integer>> ans, List<Integer> sub){
        
        if(sub.size() == k){
            ans.add(new ArrayList<>(sub));
        }

        if(i == n + 1){
            return;
        }

        sub.add(i);
        back(n, k, i + 1, ans, sub);
        sub.remove(sub.size() -1);
        back(n, k, i + 1, ans, sub);
    }
}