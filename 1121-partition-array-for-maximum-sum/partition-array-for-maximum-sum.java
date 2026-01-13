class Solution {
    int n;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n=arr.length;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,k,arr,dp);
    }
    public int solve(int idx,int k,int [] arr,int[]dp){
        if(idx==n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxarr=Integer.MIN_VALUE;
        for(int i=idx;i<Math.min(n,idx+k);i++){
            len++;
            maxi=Math.max(arr[i],maxi);
            int cost=maxi*len+solve(i+1,k,arr,dp);
            maxarr=Math.max(maxarr,cost);
        }
        return dp[idx]=maxarr;

    }
}