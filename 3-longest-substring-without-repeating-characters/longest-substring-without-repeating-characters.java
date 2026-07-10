class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int st = 0, end = 0;
        int max = 0;

        for(end = 0; end < s.length(); end++){
            while(seen.contains(s.charAt(end))){
                seen.remove(s.charAt(st++));    
            }
            
            seen.add(s.charAt(end));      
            max = Math.max(max, end - st + 1);
        }
        return max;
    }
}