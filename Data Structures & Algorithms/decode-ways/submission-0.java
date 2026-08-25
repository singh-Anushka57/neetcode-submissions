class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;//at the end
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)!='0'){
                dp[i]=dp[i+1];//every letter is a code of its own so add 1
            }
            if(i+1<n){//taking 2 digits
                int num=Integer.parseInt(s.substring(i,i+2));
                if(num>=10 && num<=26){
                    dp[i]+=dp[i+2];//adding the value of second last too
                }
            }
        }
        return dp[0];
    }
}
