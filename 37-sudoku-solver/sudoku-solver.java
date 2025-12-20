class Solution {

    boolean isSafe(char[][]board,int row,int col,int dig){
        //horizontal
        for(int j=0;j<9;j++){
            if(board[row][j]==dig) return false;
        }
        //vertical
        for(int i=0;i<9;i++){
            if(board[i][col]==dig) return false;
        }
        //grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<=sr+2;i++){
            for(int j=sc;j<=sc+2;j++){
                if(board[i][j]==dig){
                    return false;
                }
            }
        }
        return true;
    }
    boolean helper(char[][]board,int row,int col){
        if(row==9){
            return true;
        }
        int nextrow=row,nextcol=col+1;
        if(nextcol==9){
            nextrow=row+1;
            nextcol=0;
        }
        if(board[row][col]!='.'){
            return helper(board,nextrow,nextcol);
        }
        for(char i='1';i<='9';i++){
            if(isSafe(board,row,col,i)){
                board[row][col]=i;
                if(helper(board,nextrow,nextcol)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}