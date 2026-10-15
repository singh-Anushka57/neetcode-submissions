class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        int maxLen=0;
        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            maxLen=Math.max(maxLen,dfs(matrix,dp,i,j));
        }
        }
        return maxLen;
    }
    public int dfs(int[][] matrix,int[][] dp,int i,int j){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int n=matrix.length;
        int m=matrix[0].length;
        int len=1;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};
        for(int k=0;k<4;k++){
            int r=i+dr[k];
            int c=j+dc[k];
            if(r>=0 && r<n && c>=0 && c<m && matrix[r][c]>matrix[i][j]){
                len=Math.max(len,1+dfs(matrix,dp,r,c));
            }
        }
        dp[i][j]=len;
        return len;
    }
}