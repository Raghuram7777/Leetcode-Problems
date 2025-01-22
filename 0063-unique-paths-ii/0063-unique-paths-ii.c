int solve(int** g,int i,int j,int m,int n,int** dp){
    if(i>=m||j>=n)return 0;
    if(g[i][j]==1)return 0;
    if(i==m-1&&j==n-1)return 1;
    if(dp[i][j]!=-1){return dp[i][j];}
    int down=solve(g,i+1,j,m,n,dp);
    int right=solve(g,i,j+1,m,n,dp);
    dp[i][j]=down+right;
    return dp[i][j];
}
int uniquePathsWithObstacles(int** oGrid, int m, int* n) {
    int** dp=(int**)malloc(sizeof(int*)*m);
    for(int i=0;i<m;i++){
        dp[i]=(int*)malloc(sizeof(int)*(*n));
        for(int j=0;j<*n;j++){
            dp[i][j]=-1;
        }
    }
    return solve(oGrid,0,0,m,*n,dp);
}