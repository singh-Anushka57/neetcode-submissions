class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] last=new int[26];
        for(int i=0;i<s.length();i++){//fill last array with all the last occurances of the element
            last[s.charAt(i)-'a']=i;
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,last[s.charAt(i)-'a']);//max occurance of the element
            if(i==end){
                result.add(end-start+1);
                start=i+1;
            }
        }
        return result;
    }
}
