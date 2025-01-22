int solve(char* s,int i,int j,int** dp){
    if(i>j)return 0;
    if(i==j)return 1;
    if(dp[i][j]!=-1)return dp[i][j];
    if(s[i]==s[j])dp[i][j]=2+solve(s,i+1,j-1,dp);
    else{
    int one=solve(s,i+1,j,dp);
    int two=solve(s,i,j-1,dp);
    dp[i][j]=(one>two)?one:two;}
    return dp[i][j];
}
int minInsertions(char* s) {
    int len=strlen(s);
    int** dp=(int**)malloc(sizeof(int*)*len);
    for(int i=0;i<len;i++){
        dp[i]=(int*)malloc(sizeof(int)*len);
        for(int j=0;j<len;j++){
            dp[i][j]=-1;
        }
    }
    return len-solve(s,0,len-1,dp);
}