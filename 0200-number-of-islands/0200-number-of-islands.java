class Solution {
    public void dfs(char[][] grid,int[][] vis,int i,int j,int m,int n){
        if(i<0 || j<0 ||i>=m||j>=n)return;
        vis[i][j]=1;
        for(int x=i-1;x<=i+1;x++){
            if(x<0 ||x>=m)continue;
            if(grid[x][j]=='1'){
                if(vis[x][j]!=1){
                    dfs(grid,vis,x,j,m,n);
                }
            }
        }
        for(int y=j-1;y<=j+1;y++){
            if(y<0 || y>=n)continue;
            if(grid[i][y]=='1'){
                if(vis[i][y]!=1){
                    dfs(grid,vis,i,y,m,n);
                }
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(vis[i],0);
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]!=1){
                    if(grid[i][j]=='0')continue;
                    else{
                        count++;
                        dfs(grid,vis,i,j,m,n);
                    }
                }
            }
        }
        return count;
    }
}