class Solution {
    public int minCapability(int[] nums, int k) {
        int[] a=minMax(nums);
        if(nums.length==1||k==1) return a[0];
        int start=a[0],end=a[1];
        while(start<end){
            int mid=start-(start-end)/2;
            if(isRobberyPossible(nums,mid,k)) end=mid;
            else start=mid+1;
        }
        return start;
    }
    int[] minMax(int[] a){
        int min=a[0],max=a[0];
        for(int el:a) {
            max=Math.max(max,el);
            min=Math.min(min,el);
        }
        return new int[]{min,max};
    }
    boolean isRobberyPossible(int[] nums,int max,int k){
            int hr=0;//hosue robbed
            for(int i=0;i<nums.length;i++){
                     if(nums[i]<=max) {
                        hr++;
                        i++;}
                     if(hr==k) return true;
                }
            return false;
    }
}
