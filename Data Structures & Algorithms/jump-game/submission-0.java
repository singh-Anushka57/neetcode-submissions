class Solution {
    public boolean canJump(int[] nums) {
        int maxReach=0;
        for(int i=0;i<nums.length;i++){
            //If the current index i is greater than the farthest index we can reach, we are stuck. We cannot reach this position, so we return false.
            if(i>maxReach){
                return false;
            }
            maxReach=Math.max(maxReach,i+nums[i]);
            if(maxReach>=nums.length-1){
                return true;
            }
        }
        return true;
    }
}
