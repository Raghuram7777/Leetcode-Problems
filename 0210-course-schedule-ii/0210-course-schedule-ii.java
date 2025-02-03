class Solution {
    public int[] findOrder(int num, int[][] pre) {
        Queue<Integer> q=new LinkedList<>();
        int indegree[]=new int[num];
        int topo[]=new int[num];
        Arrays.fill(indegree,0);
        for(int i=0;i<pre.length;i++){
            int v=pre[i][0];
            int u=pre[i][1];
            indegree[v]++;
        }
        for(int i=0;i<num;i++){
            if(indegree[i]==0)q.offer(i);
        }
        int count=0;
        int a=0;
        while(!q.isEmpty()){
            int t=q.poll();
            topo[a++]=t;
            count++;
            for(int i=0;i<pre.length;i++){
                int u=pre[i][1];
                if(u==t){
                    int v=pre[i][0];
                    indegree[v]--;
                    if(indegree[v]==0)q.offer(v);
                } 
            }
        }
        return count==num?topo:new int[0];
    }
}