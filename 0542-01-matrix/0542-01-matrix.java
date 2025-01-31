class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int vis[][]=new int[m][n];
        int[][] arr=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    arr[i][j]=0;
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int a[]=q.poll();
            int row=a[0];
            int col=a[1];
            int level=a[2];
            if(vis[row][col]!=1)vis[row][col]=1;
            if(row+1<m && vis[row+1][col]==0 && mat[row+1][col]==1){
                vis[row+1][col]=1;
                arr[row+1][col]=level+1;
                q.offer(new int[]{row+1,col,level+1});
            }if(row-1>=0 && vis[row-1][col]==0 && mat[row-1][col]==1){
                vis[row-1][col]=1;
                arr[row-1][col]=level+1;
                q.offer(new int[]{row-1,col,level+1});
            }if(col+1<n && vis[row][col+1]==0 && mat[row][col+1]==1){
                vis[row][col+1]=1;
                arr[row][col+1]=level+1;
                q.offer(new int[]{row,col+1,level+1});
            }if(col-1>=0 && vis[row][col-1]==0 && mat[row][col-1]==1){
                vis[row][col-1]=1;
                arr[row][col-1]=level+1;
                q.offer(new int[]{row,col-1,level+1});
            }
        }
        return arr;
    }
}