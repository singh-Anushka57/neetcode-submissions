class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        String[] map={
            "","","abc","def","ghi",
            "jkl","mno","pqrs","tuv","wxyz"
        };
        backtrack(digits,map,0,new StringBuilder(),ans);
        return ans;
    }
    public void backtrack(String digits,String[] map,int index,StringBuilder current,List<String> ans){
        if(index==digits.length()){
            ans.add(current.toString());
            return;
        }
        String letters=map[digits.charAt(index)-'0'];
        for(int i=0;i<letters.length();i++){
            current.append(letters.charAt(i));
            backtrack(digits,map,index+1,current,ans);//we increase the index everytime
            current.deleteCharAt(current.length()-1);
        }
    }
}
