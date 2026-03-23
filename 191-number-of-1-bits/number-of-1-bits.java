class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            int mask = (n & (1 << i)) == 0 ? 0 : 1;
            if(mask == 1) count++;
        }

        return count;
    }
}