public class AllocateMinimumPages {
  public int findPages(int[] arr, int k) {
        if(k>arr.length) return -1;
        int start=0,end=0;
        for(int el:arr) {
            start=Math.max(el,start);
            end+=el;
        }
       while(start<end){
           int mid = start - (start-end)/2;
           if(greaterThanK(arr,mid,k)) start=mid+1;
           else end=mid;
       } return start;
    }
    private boolean greaterThanK(int[] a,int mid,int k){
        int sum=0,count=1;
        for(int el:a){
            if(sum+el>mid) {
                count++;
                if(count>k) return true;
                sum=el;
            }
            else sum+=el;
        } return false;
    }
}
