class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);
    }
    public int solve(int i,int[] nums,int[] dp){
        int n=nums.length;
        if(i>=n-1){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=nums[i];j++){
            if(i+j<n){//less than the length of the array
            int jumps=solve(i+j,nums,dp);
            if(jumps!=Integer.MAX_VALUE){
                min=Math.min(min,jumps+1);
            }
            }
        }
        return dp[i]=min;
}
}
