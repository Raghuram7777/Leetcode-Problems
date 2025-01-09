bool isPalindrome(char* s) {
    char ch[200000];
    int left=0;int right=strlen(s);
    if(right==1)return true;int j=0;
    for(int i=0;i<right;i++){
        if((s[i]>=97&&s[i]<=122 )||(s[i]>=65 && s[i]<=90)||(s[i]>=48 && s[i]<=57)){
            ch[j++]=tolower(s[i]);
        }
    }ch[j]='\0';
    int len=strlen(ch);
    right=len-1;
    while(left<=right){
        if(ch[left]!=ch[right])return false;
        left++;
        right--;
    }
    return true;

}