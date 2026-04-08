class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        for(int i = 1; i < numRows; i++){
            List<Integer> res = new ArrayList<>();
            List<Integer> temp = ans.get(i - 1);
            
            int a = 0;
            int b = 0;
            for(int j = 0; j < temp.size(); j++){
                a = b;
                b = temp.get(j);
                res.add(a + b);
            }
            
            res.add(1);
            ans.add(res);
        }

        return ans;
    }
}