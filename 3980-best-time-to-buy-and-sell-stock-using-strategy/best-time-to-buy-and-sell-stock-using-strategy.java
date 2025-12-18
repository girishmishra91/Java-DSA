class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;
        long actualProfit=0;
        long[] profit=new long[n];
        for(int i=0;i<n;i++){
            profit[i]=(long)strategy[i]*prices[i];
            actualProfit+=profit[i];
        }
        long originalwindowprofit=0;
        long modifiedwindowprofit=0;
        long maxGain=0;
        int i=0,j=0;
        while(j<n){
            originalwindowprofit+=profit[j];
            if(j-i+1>k/2){
                modifiedwindowprofit+=prices[j];
            }
            if(j-i+1>k){
                originalwindowprofit-=profit[i];
                modifiedwindowprofit-=prices[i+k/2];
                i++;
            }
            if(j-i+1==k){
                maxGain=Math.max(maxGain,modifiedwindowprofit-originalwindowprofit);
            }
            j++;
        }
        return actualProfit+maxGain;
    }
}