bool isPalindrome(int x) {
    long a=0;int b=x;
    while(x>0){
        int mod=x%10;
        a=(a*10)+mod;
        x/=10;
    }
    if(a==b)return true;
    else return false;
}