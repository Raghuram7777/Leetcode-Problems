class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int vis[]=new int[m];
        Arrays.fill(vis,-1);
        for(int j=0;j<graph.length;j++){
            if(vis[j]==-1){
            Queue<Integer> q=new LinkedList<>();
            q.offer(j);int t=0;
            vis[j]=0;
            while(!q.isEmpty()){
            int temp=q.poll();
            for(int i=0;i<graph[temp].length;i++){
                if(vis[graph[temp][i]]==-1){
                    vis[graph[temp][i]]=1-vis[temp];
                    q.offer(graph[temp][i]);
                }
                else{
                    if(vis[graph[temp][i]]==vis[temp])return false;
                }
            }
        }
}
        }
        return true;
    }
}