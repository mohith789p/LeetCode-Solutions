class Solution {
    static Map<Character , Character> mp;
    static {
        mp = new HashMap<>();
        mp.put('{','}');
        mp.put('(',')');
        mp.put('[',']');
    }

    public boolean isValid(String str) {
        Stack<Character> s = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else if (!s.isEmpty()){
                char c = s.pop();
                if (mp.get(c) != ch) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return s.isEmpty();
    }
}