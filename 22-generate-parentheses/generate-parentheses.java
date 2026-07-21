class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(int n, int l, int r, StringBuilder sb, List<String> res){
        if(n < l || l < r) return;

        if(2 * n == sb.length()){
            res.add(sb.toString());
            return;
        }

        sb.append("(");
        backtrack(n, l + 1, r, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(")");
        backtrack(n, l, r + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }
}