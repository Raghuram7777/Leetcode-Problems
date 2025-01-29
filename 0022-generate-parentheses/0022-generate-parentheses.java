class Solution {
    public boolean valid(String s){
        int c=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')c++;
            else c--;
            if(c<0)return false;
        }
        return c==0;
    }
    public void solve(StringBuilder sb,List<String> l,int n,int i){
        if(i==2*n){ 
            if(valid(sb.toString())==true){
            l.add(sb.toString());}
            return;
        }
        //generating all possible combinations
        sb.append('(');
        solve(sb,l,n,i+1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(')');
        solve(sb,l,n,i+1);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> l=new ArrayList<>();
        solve(new StringBuilder(""),l,n,0);
        return l;
    }
}