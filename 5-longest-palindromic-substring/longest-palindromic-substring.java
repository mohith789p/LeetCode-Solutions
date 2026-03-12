class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean dp[][] = new Boolean[n][n];
        int max = -1, si = 0, sj = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i >= j)
                    dp[i][j] = true;
                else {
                    if (s.charAt(i) != s.charAt(j))
                        dp[i][j] = false;
                    else {
                        if (j - i < 3)
                            dp[i][j] = true;
                        else
                            dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j] && max < j - i + 1) {
                            si = i;
                            sj = j;
                            max = j - i + 1;
                        }
                    }
                }
            }
        }

        return s.substring(si, sj + 1);
    }
}