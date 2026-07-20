class Solution {
    static Map<Integer, List<Character>> mp = Map.of(
        2, List.of('a', 'b', 'c'),
        3, List.of('d', 'e', 'f'),
        4, List.of('g', 'h', 'i'),
        5, List.of('j', 'k', 'l'),
        6, List.of('m', 'n', 'o'),
        7, List.of('p', 'q', 'r', 's'),
        8, List.of('t', 'u', 'v'),
        9, List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        backTrack(0, digits, new StringBuilder(), ans);
        return ans;
    }

    private void backTrack(int idx, String s, StringBuilder sb, List<String> res){
        if(idx == s.length()){
            res.add(sb.toString());
            return;
        }

        List<Character> ch =  mp.get(s.charAt(idx) - '0');
        
        for(int i = 0; i < ch.size(); i++){
            sb.append(ch.get(i));
            backTrack(idx + 1, s, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }
}