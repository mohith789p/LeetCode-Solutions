class Solution {
    public void solveSudoku(char[][] board) {
     solve(board);   
    }

    private boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char num = '1'; num <= '9'; num++){
                        if(isSafe(board, i, j, num)){
                            board[i][j] = num;
                            if(solve(board)) return true;
                            board[i][j] = '.'; 
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char num){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num) return false;
        }
        for(int i = 0; i < 9; i++){
            if(board[i][col] == num) return false;
        }

        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
              if(board[i][j] == num) return false;       
            }
        }

        return true;
    }
}