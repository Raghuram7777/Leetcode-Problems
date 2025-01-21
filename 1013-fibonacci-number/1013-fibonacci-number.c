int f(int n){
    if(n==0||n==1)return n;
    int p1=0;
    int p2=1;
    int fibo=0;
    for(int i=2;i<=n;i++){
        fibo=p1+p2;
        p1=p2;
        p2=fibo;
    }
    return fibo;
}
int fib(int n){
    return f(n);
}