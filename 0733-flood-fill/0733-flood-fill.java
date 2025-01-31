class Solution {
    public void dfs(int[][]image,int i,int j,int color,int m,int n,int oldc){
        if(i<0||j<0||i>=m||j>=n||image[i][j]==color||image[i][j]!=oldc)return;
        image[i][j]=color;
        dfs(image,i+1,j,color,m,n,oldc);
        dfs(image,i-1,j,color,m,n,oldc);
        dfs(image,i,j+1,color,m,n,oldc);
        dfs(image,i,j-1,color,m,n,oldc);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image,sr,sc,color,image.length,image[0].length,image[sr][sc]);
        return image;
    }
}