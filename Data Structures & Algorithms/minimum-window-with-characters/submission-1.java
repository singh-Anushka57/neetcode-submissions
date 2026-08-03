class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n)
        return "";
        int[] hash=new int[256];
        for(char c:t.toCharArray()){
            hash[c]++;
        }
        int left=0;
        int right=0;
        int cnt=0;
        int minLen=Integer.MAX_VALUE;
        int start=-1;
        while(right<n){
            if(hash[s.charAt(right)]>0)
            cnt++;
            hash[s.charAt(right)]--;
            while(cnt==m){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    start=left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)]>0)
                cnt--;
                left++;
            }
            right++;
        }
        if(start==-1)
        return "";
        return s.substring(start,start+minLen);
    }
}
