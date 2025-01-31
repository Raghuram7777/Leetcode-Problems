class Solution {
    public int orangesRotting(int[][] grid) {
        int[] mat=new int[3];
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length,n=grid[0].length;
        int vis[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){vis[i][j]=2;q.offer(new int[]{i,j,0});}
                else vis[i][j]=0;
            }
        }int maxi=0;
        while(!q.isEmpty()){
            int arr[]=q.poll();
            if(arr[0]+1<m&&vis[arr[0]+1][arr[1]]!=2&&grid[arr[0]+1][arr[1]]==1){
                q.offer(new int[]{arr[0]+1,arr[1],arr[2]+1});
                vis[arr[0]+1][arr[1]]=2;
            }if(arr[1]+1<n&&vis[arr[0]][arr[1]+1]!=2&&grid[arr[0]][arr[1]+1]==1){
                q.offer(new int[]{arr[0],arr[1]+1,arr[2]+1});
                vis[arr[0]][arr[1]+1]=2;
            }if(arr[0]-1>=0&&vis[arr[0]-1][arr[1]]!=2&&grid[arr[0]-1][arr[1]]==1){
                q.offer(new int[]{arr[0]-1,arr[1],arr[2]+1});
                vis[arr[0]-1][arr[1]]=2;
            }if(arr[1]-1>=0&&vis[arr[0]][arr[1]-1]!=2&&grid[arr[0]][arr[1]-1]==1){
                q.offer(new int[]{arr[0],arr[1]-1,arr[2]+1});
                vis[arr[0]][arr[1]-1]=2;
            }
            maxi=Math.max(maxi,arr[2]);
        }
        boolean t=true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&vis[i][j]==0)t=false;
            }
        }
        return (t==false)?-1:maxi;
    }
}