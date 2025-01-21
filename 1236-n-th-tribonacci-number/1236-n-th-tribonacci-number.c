int tribonacci(int n) {
    if(n==0||n==1)return n;
    if(n==2)return 1;
    int p1=0;
    int p2=1;
    int p3=1;
    int sum=0;
    for(int i=3;i<=n;i++){
        sum=p1+p2+p3;
        p1=p2;
        p2=p3;
        p3=sum;
    }
    return sum;
}