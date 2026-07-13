class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, 0, word, new boolean[board.length][board[0].length])) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int idx, String word, boolean[][] vis){
        if(idx == word.length()) return true;

        if(i < 0 || j >= board[0].length || j < 0 || i >= board.length || vis[i][j]) return false;

        if(board[i][j] != word.charAt(idx)) return false;

        vis[i][j] = true;
        boolean n = dfs(board, i - 1, j, idx + 1, word, vis);
        boolean e = dfs(board, i, j + 1, idx + 1, word, vis);
        boolean w = dfs(board, i + 1, j, idx + 1, word, vis);
        boolean s = dfs(board, i, j - 1, idx + 1, word, vis);
        vis[i][j] = false;

        return n || e || s || w; 
    }
}