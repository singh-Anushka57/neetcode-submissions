class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int start=0;
        int maxLength=1;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int length=2;length<=n;length++){
            for(int i=0;i<=n-length;i++){
                int j=i+length-1;
                if(s.charAt(i)==s.charAt(j)&& (length<=2||dp[i+1][j-1])){//are the 2 outside characters same? and is the inside already palindrome?//dp[i+1][j-1] brings us 1 step ahead of start and one step before last to check the inner elements
                    dp[i][j]=true;
                    if(length>maxLength){
                        maxLength=length;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
}
