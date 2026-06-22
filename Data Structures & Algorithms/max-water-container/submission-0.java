class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int water=0;
        while(left<right){
            int width=right-left;
            int curr=Math.min(heights[left],heights[right])*width;
            water=Math.max(water,curr);
            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return water;
        }
}
