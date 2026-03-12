class Solution {
    public int reverse(int x) {
        int n = x > 0 ? x : -x;
        int res = 0;
        while(n > 0){
            int r = n % 10;
            if((long) res * 10 + r > Integer.MAX_VALUE)
                return 0;
            res = res * 10 + r;
            n = n / 10;
        }

        return x > 0 ? res : -res;
    }
}