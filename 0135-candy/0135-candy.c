int candy(int* r, int rsize) {
    if (rsize == 0) return 0;
    int sum=1;int up=0;
    int peak=0,down=0;int i=1;
    while(i< rsize){
        if(r[i]>r[i-1]){
            up++;
            peak=up;
            down=0;
            sum+=up+1;
        }
        else if(r[i]==r[i-1]){
            up=down=peak=0;
            sum+=1;
        }
        else{
            up=0;
            down++;
            sum+=down;
            if(down>peak)sum+=1;
        }
        i++;
    }
    return sum;
}