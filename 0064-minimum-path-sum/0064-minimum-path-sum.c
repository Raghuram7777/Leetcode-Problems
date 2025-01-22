int solve(int** g,int i,int j,int m,int n,int** dp){
    if(i>=m||j>=n)return INT_MAX;
    if(i==m-1&&j==n-1)return g[i][j];
    if(dp[i][j]!=-1){
        return dp[i][j];
    }
    int d=solve(g,i+1,j,m,n,dp);
    int r=solve(g,i,j+1,m,n,dp);
    dp[i][j]=g[i][j]+( d<r?d:r);
    return dp[i][j];
}
int minPathSum(int** grid, int m, int* n) {
    int** dp=(int**)malloc(sizeof(int*)*m);
    for(int i=0;i<m;i++){
        dp[i]=(int*)malloc(sizeof(int)**n);
        for(int j=0;j<*n;j++){
            dp[i][j]=-1;
        }
    }
    return solve(grid,0,0,m,*n,dp);
}