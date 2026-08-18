class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> arr=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>(),arr);
        return arr;
    }
    private void backtrack(int start,int[] candidates,int target,List<Integer> val,List<List<Integer>> arr){
        if(target==0){
            arr.add(new ArrayList<>(val));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            val.add(candidates[i]);
            backtrack(i+1,candidates,target-candidates[i],val,arr);
            val.remove(val.size()-1);
        }
    }
}
