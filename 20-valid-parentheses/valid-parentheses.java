class Solution {
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '{' || ch == '[' || ch == '('){
                sk.push(ch);
            }

            else {
                if (sk.isEmpty())
                    return false;
                char top = sk.pop();

                if(ch == ')' && top != '(')
                    return false;

                if(ch == ']' && top != '[')
                    return false;

                if(ch == '}' && top != '{')
                    return false;
        
            }
        }

        return sk.isEmpty();
    }
}