class Solution {
    public void dfs(char[][] board,int vis[][],int i,int j,int m,int n){
        if(i<0||j<0||i>m-1||j>n-1||vis[i][j]==1||board[i][j]=='X'){
            return;
        }
        vis[i][j]=1;
        dfs(board,vis,i+1,j,m,n);
        dfs(board,vis,i-1,j,m,n);
        dfs(board,vis,i,j+1,m,n);
        dfs(board,vis,i,j-1,m,n);
    }
    public void solve(char[][] board) {
        int m=board.length,n=board[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(vis[i],0);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O')dfs(board,vis,0,j,m,n);
        }
        for(int j=0;j<n;j++){
            if(board[m-1][j]=='O')dfs(board,vis,m-1,j,m,n);
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')dfs(board,vis,i,0,m,n);
        }
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O')dfs(board,vis,i,n-1,m,n);
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(vis[i][j]==0&& board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}