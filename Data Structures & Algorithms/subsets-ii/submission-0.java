class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> arr=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,arr,new ArrayList<>(),0);
        return arr;
    }
    public void backtrack(int[] nums,List<List<Integer>> arr,List<Integer> val,int start){
      arr.add(new ArrayList<>(val));
        for(int i=start;i<nums.length;i++){
             if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            val.add(nums[i]);
            backtrack(nums,arr,val,i+1);
            val.remove(val.size()-1);
        }
    }
}
