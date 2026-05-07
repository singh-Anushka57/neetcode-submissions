class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int current=1;
        int y=0;
        if(nums.length==0)return 0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i:nums){
            if(!set.contains(i-1)){
                current=i;
                int count=1;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
            y=Math.max(y,count);
        }
        }
        return y;
    }
}
