// Valid Sudoku
  
class Solution {
    public boolean isValidSudoku(char[][] board) {
      
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int curr = board[i][j];
                if(!isSafe(board, i, j, curr)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean isSafe(char[][] board, int row, int col, int curr) {
        
        for(int i = 0; i < 9; i++) {
            if(i == row) continue;
            if(board[i][col] == curr) return false;
        }

        for(int j = 0; j < 9; j++) {
            if(j == col) continue;
            if(board[row][j] == curr) return false;
        }

        int actI = row;
        int actJ = col;
        int remX = row%3;
        int remY = col%3;
        if(remX != 0) row -= remX;
        if(remY != 0) col -= remY;
        for(int i = row; i < row+3; i++) {
            for(int j = col; j < col+3; j++) {
                if(i == actI && j == actJ) continue;
                if(board[i][j] == curr) return false;
            }
        }

        return true;
    }
}
