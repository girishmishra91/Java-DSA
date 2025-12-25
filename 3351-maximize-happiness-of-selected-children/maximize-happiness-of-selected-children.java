class Solution {
    private void reverseArray(int[]arr){
        int st=0;
        int end=arr.length-1;
        while(st<end){
            int temp=arr[st];
            arr[st]=arr[end];
            arr[end]=temp;
            st++;
            end--;
        }
    }
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        reverseArray(happiness);
        long result=0;
        int count=0;
        for(int i=0;i<k;i++){
            result+=Math.max(happiness[i]-count,0);
            count++;
        }
        return result;
    }
}