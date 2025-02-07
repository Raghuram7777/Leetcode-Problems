class Solution {
    public boolean ispalindrome(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l) !=s.charAt(r))return false;
            r--;
            l++;
        }return true;
    }
    public String longestPalindrome(String s) {
        int maxi=0;StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            for(int j=s.length()-1;j>=i;j--){
                if(ispalindrome(s,i,j)){
                    if((j+1-i)>maxi){
                        maxi=j+1-i;
                        sb = new StringBuilder(s.substring(i, j+1));
                    }
                }
            }
        }
        return sb.toString();
    }
}