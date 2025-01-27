class Solution {
    public int eraseOverlapIntervals(int[][] iv) {
        Arrays.sort(iv,(a,b)->(a[1]-b[1]));
        int count=1;
        int s=iv[0][0];
        int e=iv[0][1];
        for(int i=1;i<iv.length;i++){
            if(iv[i][0]>=e){count++;
            e=iv[i][1];}
        }
        return iv.length-count;
    }
}