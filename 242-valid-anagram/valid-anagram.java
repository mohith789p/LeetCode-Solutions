class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(char ch : s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch,0) + 1);
        }

        for(char ch : t.toCharArray()){
            if(!mp.containsKey(ch) || mp.get(ch) == 0)
                return false;
            mp.put(ch, mp.get(ch) - 1);
        }

        return true;
    }
}