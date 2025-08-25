import java.util.Arrays;

public class MaximizeMedian {
  public int maximizeMedian(int[] arr, int k) {
        if(arr.length==1) return arr[0]+k;
        Arrays.sort(arr);
        long start,end;
        int mid;
        if(arr.length%2==0) {
            mid=arr.length/2-1;
            start=arr[mid];
            end=arr[mid+1]+k;
        }
        else{
            mid=arr.length/2;
            start=arr[mid];
            end=arr[mid]+k;
        }
        while(start<end-1){
            long target=start-(start-end)/2;
            if(operations(arr,mid,target)<=k) start=target;
            else end=target-1;
        }
        return operations(arr,mid,end)<=k?(int)end:(int)start;
    }
    private long operations(int[] arr,int index,long target){
        long op=0;
        if(arr.length%2==0){
            op+=1L*2*target-arr[index++]-arr[index++];
        } 
        for(int i=index;i<arr.length;i++){
            op+=Math.max(target-arr[i],0);
        } return op;
    }
}
