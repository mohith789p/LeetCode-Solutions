class Solution {
    public int maximumLengthSubstring(String s) {
        int[] c = new int[26];

        int max = 0;
        int st = 0, end = 0;

        for (; end < s.length(); end++) {
            char ch = s.charAt(end);
            c[ch - 'a']++;

            while(c[ch - 'a'] > 2){
                c[s.charAt(st) - 'a']--;
                st++;
            }

            max = Math.max(max, end - st + 1);
        }
        return max;
    }
}