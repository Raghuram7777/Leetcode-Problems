class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i:nums){q.add(i);}
        int res=0;
        for(int i=0;i<nums.length+1-k;i++){
            res=q.poll();
        }
        return res;
    }
}