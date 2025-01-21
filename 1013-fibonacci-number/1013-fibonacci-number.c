int f(int n,int* dp){
    if(n==0||n==1){
        return n;
    }
    dp[n]=f(n-1,dp)+f(n-2,dp);
    return dp[n];
}
int fib(int n){
    int *dp=(int *)malloc((sizeof(int))*(n+1));
    return f(n,dp);
}