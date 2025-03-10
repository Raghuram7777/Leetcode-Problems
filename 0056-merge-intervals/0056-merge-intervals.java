class Solution {
    public int[][] merge(int[][] arr) {
       int n=arr.length;
       Arrays.sort(arr,(a,b)->(a[0]-b[0]));
       ArrayList<int[]> list=new ArrayList<>();
       list.add(arr[0]);
       for(int i=1;i<n;i++){
        int[] x=list.get(list.size()-1);
        if(arr[i][0]<=x[1]){
            int[] y=Arrays.copyOf(x,2);
            y[1]=Math.max(x[1],arr[i][1]);
            list.remove(list.size()-1);
            list.add(y);
        }else{
            list.add(arr[i]);
        }
       }
       int res[][]=new int[list.size()][2];
       for(int i=0;i<res.length;i++){
        res[i]=Arrays.copyOf(list.get(i),2);
       }
       return res;
    }
}