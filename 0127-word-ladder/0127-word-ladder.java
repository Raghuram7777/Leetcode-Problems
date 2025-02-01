class pair{
    int l;
    String st;
    pair(String st,int l){
        this.st=st;
        this.l=l;
    }
}
class Solution {
    public int ladderLength(String begin, String end, List<String> word) {
        HashSet<String> hs=new HashSet<>();
        for(String i:word){
            hs.add(i);
        }
        if (!hs.contains(end)) return 0;
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(begin,1));
        while(!q.isEmpty()){
            pair p=q.poll();
            String sb=p.st;
            int level=p.l;
            if(sb.equals(end))return level;
            for(int i=0;i<sb.length();i++){
                char[] ch=sb.toCharArray();
                char o=ch[i];
                for(char c='a';c<='z';c++){
                    if(c!=o){
                        ch[i]=c;
                        String news=new String(ch);
                        if(hs.contains(news)){
                            hs.remove(news);
                            q.offer(new pair(news,level+1));
                        }
                    }
                }
                ch[i]=o;
            }
        }
        return 0;
    }
}