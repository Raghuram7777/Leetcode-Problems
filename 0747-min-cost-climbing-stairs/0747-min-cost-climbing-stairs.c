int solve(int* cost,int n,int cS,int* dp){
    if(n<0)return 0;
    if(dp[n]!=-1){return dp[n];}
    dp[n]=cost[n]+(solve(cost,n-1,cS,dp)>solve(cost,n-2,cS,dp)?solve(cost,n-2,cS,dp):solve(cost,n-1,cS,dp));
    return dp[n];
}
int minCostClimbingStairs(int* cost, int costSize) {
    int n=costSize;
    int* dp=(int*)malloc(sizeof(int)*n);
    for(int i=0;i<n;i++){dp[i]=-1;}
    return (solve(cost,n-1,n,dp)>solve(cost,n-2,n,dp)?solve(cost,n-2,n,dp):solve(cost,n-1,n,dp));
}