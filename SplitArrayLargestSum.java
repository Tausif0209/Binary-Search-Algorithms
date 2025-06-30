public class SplitArrayLargestSum {
  public int splitArray(int[] arr, int k) {
       int start=max(arr),end=sum(arr);
       while(start<end){
           int mid=start -(start-end)/2;
           if(split(arr,mid,k)) end=mid;
           else start=mid+1;
       }
       return start;
    }
    private boolean split(int[] arr,int mid,int k){
        int n=1;//number of split
        int sum=0;
        for(int el:arr){
            sum+=el;
            if(sum>mid){
                sum=el;
                n++;
                if(n>k) return false;
            }
        } return true;
    }
    private int sum(int[] arr){
        int sum=0;
        for(int el:arr) sum+=el;
        return sum;
    }
    private int max(int[] arr){
        int max=arr[0];
        for(int el:arr) max=Math.max(max,el);
        return max;
    }
}
