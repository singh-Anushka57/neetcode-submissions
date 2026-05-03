class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> map=new HashSet<>();
        for(int i:nums){
            if(map.contains(i)){
                return true;
            }
            else
            map.add(i); 
        }
        return false;
    }
}