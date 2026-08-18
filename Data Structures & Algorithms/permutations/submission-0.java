class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> arr=new ArrayList<>();
       boolean[] used = new boolean[nums.length];
       backtrack(nums,new ArrayList<>(),arr,used);
       return arr; 
    }
    private void backtrack(int[] nums,List<Integer> val,List<List<Integer>> arr,boolean[] used){
        if (val.size() == nums.length) {
    arr.add(new ArrayList<>(val));
    return;
}
        for(int i=0;i<nums.length;i++){
             if (used[i]) {
                continue;
            }
            used[i] = true;
            val.add(nums[i]);
            
            backtrack(nums,val,arr,used);
            val.remove(val.size()-1);
            used[i]=false;
        }
    }
}
