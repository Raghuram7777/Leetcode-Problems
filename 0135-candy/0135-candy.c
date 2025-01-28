int candy(int* r, int rsize) {
    if (rsize == 0) return 0;
    int sum=0;
    int nums[rsize];
    for(int i=0;i<rsize;i++)nums[i]=1;
    for(int i=1;i<rsize;i++){
        if(r[i]>r[i-1]){
            nums[i]=nums[i-1]+1;
        }
    }
    for(int i=rsize-2;i>=0;i--){
        if(r[i]>r[i+1]){
            nums[i]=(nums[i]>nums[i+1]+1)?nums[i]:(nums[i+1]+1);
        }
    }
    for(int i=0;i<rsize;i++){
        sum+=nums[i];
    }
    return sum;
}