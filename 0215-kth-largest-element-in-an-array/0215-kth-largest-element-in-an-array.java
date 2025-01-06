class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>((n1,n2) -> n2-n1);
        for(int i:nums){q.add(i);}
        int res=0;
        for(int i=0;i<k;i++){
            res=q.poll();
        }
        return res;
    }
}