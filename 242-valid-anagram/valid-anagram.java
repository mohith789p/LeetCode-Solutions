class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mp = new HashMap<>();

        for(char ch : s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch,0) + 1);
        }

        for(char ch : t.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);
            if(mp.get(ch) == 0) mp.remove(ch);
        }

        return mp.size() == 0;
    }
}