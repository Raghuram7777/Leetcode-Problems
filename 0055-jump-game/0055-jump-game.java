class Solution {
    public int jump(int[] nums,int i,int dp[]){
        if(i>=nums.length-1)return 1;
        if(dp[i]!=-1)return dp[i];
        int maxjump=Math.min(i+nums[i],nums.length-1);
        for(int j=i+1;j<=maxjump;j++){
            dp[j]=jump(nums,j,dp);
        }
        return 0;
    }
    public boolean canJump(int[] nums) {
        if(nums.length==1)return true;
        int dp[] =new int[nums.length];Arrays.fill(dp,-1);
        int res= jump(nums,0,dp);
        return dp[nums.length-1]==1;
    }
}