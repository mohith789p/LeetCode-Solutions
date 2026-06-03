class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n];

        for(int[] t : trust){
            score[t[0] - 1]--;
            score[t[1] - 1]++;
        }

        for(int i = 0; i < n; i++){
            if(score[i] == n - 1) return i + 1;
        }

        return -1;
    }
}