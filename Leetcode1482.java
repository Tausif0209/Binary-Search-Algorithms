public class Leetcode1482 {
   public int minDays(int[] bloomDay, int m, int k) {
        if(1L*m*k>bloomDay.length) return -1;
        int start=Integer.MAX_VALUE,end=Integer.MIN_VALUE;
        for(int day:bloomDay){
            start=Math.min(start,day);
            end=Math.max(end,day);
        }
        while(start<end){
            int mid=start-(start-end)/2;
            if(maxBouquets(mid,bloomDay,k)<m) start=mid+1;
            else end=mid;
        } return start;
    }
    private int maxBouquets(int maxDay,int[] bloomDay,int k){
        int bouquets=0,flowers=0;
        for(int day:bloomDay){
            if(day<=maxDay){
                flowers++;
                if(flowers==k) {
                    bouquets++;
                    flowers=0;
                }
            }
            else flowers=0; 
        } return bouquets;
    }
}
