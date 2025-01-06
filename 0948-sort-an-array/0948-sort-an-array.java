class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i:nums){
            q.add(i);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=q.poll();
        }
        return nums;
    }
}