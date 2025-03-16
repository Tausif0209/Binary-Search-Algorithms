class Solution {
    public long repairCars(int[] ranks, int cars) {
        long start=1,end=min(ranks)*(long)cars*cars;
        while(start<end){
            long mid=start-(start-end)/2;
            if(isRepairPossible(mid,ranks,cars)) end=mid;
            else start=mid+1;
        }
        return start;
    }
    int min(int[] a){
        int min=a[0];
        for(int el:a) min=Math.min(min,el);
        return min;
     }
     boolean isRepairPossible(long min,int[] ranks,int cars){
         int cr=0;//cars repaired
         for(int r:ranks){
            cr+=(int)Math.sqrt(min/r);
            if(cr>=cars) return true;
         }
         return false;
     }
}