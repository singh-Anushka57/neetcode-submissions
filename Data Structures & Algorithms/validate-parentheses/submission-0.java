class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='(' || c=='{'||c=='['){
                st.push(c);
            }
            else{
                if(st.isEmpty())
                return false;//if you find a closing bracket and the stack doesnot have an opening bracket
                char top=st.pop();
                if((c==')' && top!='(')||
                (c==']' && top!='[')||
                (c=='}' && top!='{'))
                return false;
            }
        }
        return st.isEmpty();
    }
}
