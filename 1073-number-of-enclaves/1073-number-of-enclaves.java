class Solution {
    public void dfs(int[][] grid,int vis[][],int i,int j,int m,int n){
        if(i<0||j<0||i>m-1||j>n-1||vis[i][j]==1||grid[i][j]==0){
            return;
        }
        vis[i][j]=1;
        dfs(grid,vis,i+1,j,m,n);
        dfs(grid,vis,i-1,j,m,n);
        dfs(grid,vis,i,j+1,m,n);
        dfs(grid,vis,i,j-1,m,n);
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(vis[i],0);
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==1)dfs(grid,vis,0,j,m,n);
        }
        for(int j=0;j<n;j++){
            if(grid[m-1][j]==1)dfs(grid,vis,m-1,j,m,n);
        }
        for(int i=0;i<m;i++){
            if(grid[i][0]==1)dfs(grid,vis,i,0,m,n);
        }
        for(int i=0;i<m;i++){
            if(grid[i][n-1]==1)dfs(grid,vis,i,n-1,m,n);
        }int count=0;
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(vis[i][j]==0&& grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}