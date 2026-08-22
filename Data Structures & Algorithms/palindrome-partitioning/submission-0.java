class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> str=new ArrayList<>();
        backtrack(s,str,new ArrayList<>(),0);
        return str;
    }
    public void backtrack(String s,List<List<String>> str,List <String> val,int start){
        if(start==s.length()){
            str.add(new ArrayList<>(val));
            return;
        }
        for(int i=start;i<s.length();i++){
            String part=s.substring(start,i+1);
            if(isPalindrome(part)){
                val.add(part);
                backtrack(s,str,val,i+1);
                val.remove(val.size()-1);
            }
        }
        }
    
    public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}
}
