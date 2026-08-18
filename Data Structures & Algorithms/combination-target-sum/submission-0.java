class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> arr=new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),arr,target);
        return arr;
    }
    private void backtrack(int start,int[] nums,List<Integer> val,List<List<Integer>> arr,int target){
        if(target==0){
        arr.add(new ArrayList<>(val));
        return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<nums.length;i++){
            val.add(nums[i]);
            backtrack(i,nums,val,arr,target-nums[i]);
            
            val.remove(val.size()-1);
        }
    }
}
