void dfs(int node,int** isC,int* vis,int col){
    if(vis[node]!=1)vis[node]=1;
    for(int i=0;i<col;i++){
        if(isC[node-1][i]==1){
            if(vis[i+1]==0){
                dfs(i+1,isC,vis,col);
            }
        }
    }
    return;
}
int findCircleNum(int** isC, int isCSize, int* col) {
    int vis[isCSize+1];
    for(int i=0;i<=isCSize;i++){
        vis[i]=0;
    }
    int count=0;
    for(int i=1;i<=isCSize;i++){
        if(vis[i]==0){
            count++;
            dfs(i,isC,vis,*col);
        }
    }
    return count;
}