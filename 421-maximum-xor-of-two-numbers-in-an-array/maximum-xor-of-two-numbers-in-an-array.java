class TrieNode{
    TrieNode children[] = new TrieNode[2];
}

class Trie{
    TrieNode root = new TrieNode();

    void add (int num) {
        TrieNode cur = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            
            if (cur.children[bit] == null) {
                cur.children[bit] = new TrieNode();
            }
            
            cur = cur.children[bit];
        }
    }

    int getMax (int num) {
        TrieNode cur = root;
        int ans = 0;
        
        for (int i = 30; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            int opp = 1 - bit;

            if (cur.children[opp] != null) {
                ans |= (1 << i);

                cur = cur.children[opp];
            } else {
                cur = cur.children[bit];
            }
        }

        return ans;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num : nums){
            trie.add(num);
        }

        int max = 0;
        for(int num : nums){
            max = Math.max(max, trie.getMax(num));
        }

        return max;
    }
}