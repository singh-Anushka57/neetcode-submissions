class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
        int[] need=new int[128];
        int[] window=new int[128];
        for(char c:t.toCharArray())
        need[c]++;
        int required=t.length();
        int formed=0;
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int start=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window[c]++;
            if(window[c]<=need[c])
            formed++;
            while(formed==required){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    start=left;
                }
                char remove=s.charAt(left);
                window[remove]--;
                if(window[remove]<need[remove])
                formed--;
                left++;
            }
        }
        if(minLen==Integer.MAX_VALUE)
        return "";
        return s.substring(start,start+minLen);
    }
}
