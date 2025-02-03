class Solution {
    public boolean dfs(int[][] graph,int[] vis,int a,int path[],int safe[]){
        vis[a]=1;
        path[a]=1;
        for(int i=0;i<graph[a].length;i++){
            if(vis[graph[a][i]]==0){
                if(dfs(graph,vis,graph[a][i],path,safe)){safe[a]=0;return true;}
            }else if(path[graph[a][i]]==1){
                safe[a]=0;
                return true;
            }
        }
        path[a]=0;
        safe[a]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list=new ArrayList<>();
        int m=graph.length;
        int path[]=new int[m];
        int safe[]=new int[m];
        Arrays.fill(safe,-1);
        int vis[]=new int[m];
        Arrays.fill(vis,0);
        for(int i=0;i<m;i++){
            if(safe[i]==-1){
                dfs(graph,vis,i,path,safe);
            }
        }
        for(int i=0;i<safe.length;i++){
            if(safe[i]==1)
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }
}