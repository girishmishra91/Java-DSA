class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int count=0;
        int sum=0;
        for(int p=0;p<=k-1;p++){
            sum+=arr[p];
        }
        int avg=sum/k;
        if(avg>=threshold){
            count++;
        }
        int i=1,j=k;
        while(j<n){
            sum=sum-arr[i-1]+arr[j];
            int avgi=sum/k;
            if(avgi>=threshold){
                count++;
            }
            i++;j++;
        }
        return count;
    }
}