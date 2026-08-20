class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> arr=new ArrayList<>();
        backtrack(arr,new StringBuilder(),0,0,n);
        return arr;
    }
    public void backtrack(List<String> arr,StringBuilder s,int open,int close,int n){
        if(s.length()==2*n){
            arr.add(s.toString());
            return;
        }
        if(open<n){
            s.append('(');
            backtrack(arr,s,open+1,close,n);
            s.deleteCharAt(s.length()-1);
        }
        if(close<open){
            s.append(')');
            backtrack(arr,s,open,close+1,n);
            s.deleteCharAt(s.length()-1);
        }
    }
}
