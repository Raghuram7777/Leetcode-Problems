int solve(char* a,char* b,int i,int j,int**dp,int l1,int l2){
    if(i>=l1||j>=l2)return 0;
    if(dp[i][j]!=-1)return dp[i][j];
    if(a[i]==b[j])dp[i][j]=1+solve(a,b,i+1,j+1,dp,l1,l2);
    else{
        int one=solve(a,b,i+1,j,dp,l1,l2);        
        int two=solve(a,b,i,j+1,dp,l1,l2);
        dp[i][j]=one<two?two:one;     
    }
    return dp[i][j];
}
int longestCommonSubsequence(char* text1, char* text2) {
    int** dp=(int**)malloc(sizeof(int*)*(strlen(text1)+1));
    for(int i=0;i<=strlen(text1);i++){
        dp[i]=(int*)malloc(sizeof(int)*(strlen(text2)+1));
        for(int j=0;j<=strlen(text2);j++){
            dp[i][j]=-1;
        }
    }
    return solve(text1,text2,0,0,dp,strlen(text1),strlen(text2));
}