int solve(int* nums,int n,int* dp){
    if(n<0)return 0;
    if(dp[n]!=-1)return dp[n];
    int a=nums[n]+solve(nums,n-2,dp);
    int b=solve(nums,n-1,dp);
    dp[n]=a<b?b:a;
    return dp[n];
}
int rob(int* nums, int numsSize) {
    int n=numsSize;
    int* dp=(int*)malloc(sizeof(int)*n);
    for(int i=0;i<n;i++)dp[i]=-1;
    return solve(nums,n-1,dp)<solve(nums,n-2,dp)?solve(nums,n-2,dp):solve(nums,n-1,dp);
}