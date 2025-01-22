int solve(char* s,int i,int j,int** dp,int l){
    if(i>j)return 0;
    if(i==j)return 1;
    if(dp[i][j]!=-1)return dp[i][j];
    if(s[i]==s[j])dp[i][j]=2+solve(s,i+1,j-1,dp,l);
    else{
    int one=solve(s,i+1,j,dp,l);
    int two=solve(s,i,j-1,dp,l);
    dp[i][j]=(one>two)?one:two;}
    return dp[i][j];
}
int longestPalindromeSubseq(char* s) {
    int** dp=(int**)malloc(sizeof(int*)*strlen(s));
    int len=strlen(s);
    for(int i=0;i<len;i++){
        dp[i]=(int*)malloc(sizeof(int)*len);
        for(int j=0;j<len;j++){
            dp[i][j]=-1;
        }
    }
    return solve(s,0,len-1,dp,len-1);
}