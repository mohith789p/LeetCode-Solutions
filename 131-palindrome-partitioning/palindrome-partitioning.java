import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTrack(0, s, new StringBuilder(), new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int idx, String s, StringBuilder sb, List<String> sub, List<List<String>> res) {
        if (idx == s.length()) {
            if (sb.length() == 0) {
                res.add(new ArrayList<>(sub));
            }
            return;
        }

        sb.append(s.charAt(idx));

        if (isPalindrome(sb)) {
            sub.add(sb.toString());
            backTrack(idx + 1, s, new StringBuilder(), sub, res);
            sub.remove(sub.size() - 1);
        }

        backTrack(idx + 1, s, sb, sub, res);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isPalindrome(StringBuilder s) {
        if (s.length() == 0) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}