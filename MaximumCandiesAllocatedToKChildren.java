class Solution {
    public int maximumCandies(int[] candies, long k) {
        if(sum(candies)<k) return 0;
        int start=1,end=max(candies);
        while(start<end-1){
           int mid=start-(start-end)/2;
            if(greaterOrEqualK(candies,k,mid)) start=mid;
            else end=mid-1;
        }
        return (greaterOrEqualK(candies,k,end))?end:start;
    }
    int max(int[] a){
        int max=a[0];
        for(int el:a) max=Math.max(max,el);
        return max;
    }
    boolean greaterOrEqualK(int[] candies,long k,int x){
       long count=0;
       for(int el:candies){
            count+=el/x;
            if(count>=k) return true;
       } 
       return false;
    }
    long sum(int[] a) {
        long sum=0;
        for(int el:a) sum+=el;
        return sum;
    }
}