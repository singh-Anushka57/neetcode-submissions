class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s:strs){//length of string#then string
            sb.append(s.length())
              .append('#')
              .append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }//doesn't find the number but finds the # symbol
            int len=Integer.parseInt(str.substring(i,j));//gives the integer in between the i value and the #,and i keeps on updating to j after the loop
            String word=str.substring(j+1,j+1+len);//extract the string from j+1 to j+1+len
            ans.add(word);//add in ans
            i=j+1+len;
        }
        return ans;
    }
}
