class Solution {
    public boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(valid(board,i,j,c)){
                            board[i][j]=c;
                        if(solve(board)){
                            return true;
                        }
                        else{
                            board[i][j]='.';
                        }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean valid(char[][] board,int i,int j,char c){
        for(int row=0;row<9;row++){
            if(row!=i){
                if(board[row][j]==c)return false;
            }
        }
        for(int col=0;col<9;col++){
            if(col!=j){
                if(board[i][col]==c)return false;
            }
        }
        int r=(i/3)*3;
        int m=(j/3)*3;
        for(int x=r;x<r+3;x++){
            for(int y=m;y<m+3;y++){
                if(x!=i&&y!=j){
                    if(board[x][y]==c)return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}