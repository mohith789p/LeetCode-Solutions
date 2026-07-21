class Solution {
    private int count;
    public int totalNQueens(int n) {
        count = 0;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        solve(board, 0, n);
        return count;
    }

    private void solve(char[][] board, int row, int n){
        if(row == n){
            count++;
            return;
        }

        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                solve(board, row + 1, n);
                board[row][j] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        for(int i = 0; i < row; i++)
            if(board[row][i] == 'Q')
                return false;

        for(int i = 0; i < board.length; i++)
            if(board[i][col] == 'Q')
                return false;

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == 'Q')
                return false;

        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if(board[i][j] == 'Q')
                return false;
        
        return true;
    }
}