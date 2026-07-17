class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        long ans = 0;

        for (int x : nums) {
            int cur = gcd(x, k);
            int temp = k / cur;

            for (int div : mp.keySet()) {
                if (div % temp == 0) {
                    ans += mp.get(div);
                }
            }

            mp.put(cur, mp.getOrDefault(cur, 0) + 1);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}