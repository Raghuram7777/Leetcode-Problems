class Solution {
    public char find(char a,char par[]){
        if(par[a-'a']==a)return a;
        return par[a-'a']=find(par[a-'a'],par);
    }
    public void union(char a,char b,char[]par){
        char ula=find(a,par);
        char ulb=find(b,par);
        int ia=ula-'a';
        int ib=ulb-'a';
        if(ula==ulb)return;
        if(ia<ib){
            par[ib]=ula;
        }else{
            par[ia]=ulb;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String base) {
        char par[]=new char[26];
        int rank[]=new int[26];
        Arrays.fill(rank,0);
        int k=0;
        for(char c='a';c<='z';c++){
            par[k++]=c;
        }
        for(int i=0;i<s1.length();i++){
            union(s1.charAt(i),s2.charAt(i),par);
        }
        String a="";
        for(int i=0;i<base.length();i++){
            a+=find(base.charAt(i),par);
        }
        return a;
    }
}