int lengthOfLongestSubstring(char* s) {
    if(strlen(s)==1)return 1;
    int ch[128];
    for(int i=0;i<127;i++)ch[i]=-1;
    int start=-1;int maxi=0;
    for(int i=0;s[i];i++){
        if(ch[s[i]]>start){
            start=ch[s[i]];
        }
        ch[s[i]]=i;
        maxi=maxi<i-start?i-start:maxi;
    }
    return maxi;
}