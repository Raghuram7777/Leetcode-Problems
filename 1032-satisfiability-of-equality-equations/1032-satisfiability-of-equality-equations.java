class Solution {
    public char find(char a,ArrayList<Character> par){
        int idx = a - 'a';  // Direct index calculation
        if (par.get(idx) == a) return a;
        char root = find(par.get(idx), par);
        par.set(idx, root);  // Path compression
        return root;
    }
    public void union(char a,char b,ArrayList<Character> par,ArrayList<Integer> rank){
        char ulpa=find(a,par);
        char ulpb=find(b,par);
        if(ulpa==ulpb)return;
        int ia=ulpa-'a';
        int ib=ulpb-'a';
        if(rank.get(ia)>rank.get(ib)){
            par.set(ib,ulpa);
        }else if(rank.get(ia)<rank.get(ib)){
            par.set(ia,ulpb);
        }else{
            par.set(ia,ulpb);
            rank.set(ia,rank.get(ia)+1);
        }
    }
    public boolean equationsPossible(String[] eq) {
        ArrayList<Character> par=new ArrayList<>();
        ArrayList<Integer> rank=new ArrayList<>();
        for(char c='a';c<='z';c++){
            par.add(c);
            rank.add(0);
        }
        for(String st:eq){
            if(st.charAt(1)=='='){
                union(st.charAt(0),st.charAt(3),par,rank);
            }
        }for(String st:eq){
            if(st.charAt(1)=='!'){
                char one =find(st.charAt(0),par);
                char two =find(st.charAt(3),par);
                if(one==two)return false;
            }
        }
        return true;
    }
}