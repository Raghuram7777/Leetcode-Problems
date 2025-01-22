int solve(int* nums1,int n1,int* nums2,int n2,int i,int j,int**dp){
    if(i>=n1||j>=n2)return 0;
    if(dp[i][j]!=-1)return dp[i][j];
    if(nums1[i]==nums2[j])return 1+solve(nums1,n1,nums2,n2,i+1,j+1,dp);
    int one=solve(nums1,n1,nums2,n2,i+1,j,dp);
    int two=solve(nums1,n1,nums2,n2,i,j+1,dp);
    return dp[i][j]=one>two?one:two;
}
int maxUncrossedLines(int* nums1, int n1, int* nums2, int n2) {
    int** dp = (int**)malloc(n1 * sizeof(int*));
    for (int i = 0; i < n1; i++) {
        dp[i] = (int*)malloc(n2 * sizeof(int));
        memset(dp[i], -1, n2 * sizeof(int));
    }
    return solve(nums1,n1,nums2,n2,0,0,dp);
}