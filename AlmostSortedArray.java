public class AlmostSortedArray {
  public int findTarget(int arr[], int target) {
    if(arr.length==1) return (arr[0]==target)?0:-1;
    if(arr.length==2 ) {
        if(arr[0]==target) return 0;
        return arr[1]==target ?1:-1;
    }
    // for(int i=0;i<arr.length;i++) if(arr[i]==target) return i;
    // return -1;
    int start=0,mid,end=arr.length-1;
    while(start<=end){
        mid=start - (start-end)/2;
        if(arr[mid]==target) return mid;
        if (mid+1<arr.length && arr[mid+1]==target) return mid+1;
        if(mid-1>=0 && arr[mid-1]==target) return mid-1;
        if(arr[mid]>target) end=mid-1;
        else start=mid+1;
    } return -1;
}
}
