class Solution {
    static int high = 1162261467;
    public int getHigh(){
        int i;
        for(i = 1; i < Integer.MAX_VALUE / 3; i*=3);
        return i;
    }
    public boolean isPowerOfThree(int n) {
        return n > 0 && high % n == 0;
    }
}