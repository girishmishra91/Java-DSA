class Solution {
    public int minCost(int n, int[] cuts) {
        int[] newCut=new int[cuts.length+2];
        newCut[0]=0;
        newCut[newCut.length-1]=n;
        Arrays.sort(cuts);
        int x=newCut.length;
        int[][] dp=new int[x+1][x+1];
        for(int i=0;i<x;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<cuts.length;i++){
            newCut[i+1]=cuts[i];
        }
        return solve(1,cuts.length,newCut,dp);

    }
    public int solve(int i,int j,int[]arr,int[][] dp){
        if(i>j) return 0;
        int mini=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int idx=i;idx<=j;idx++){
            int cost=arr[j+1]-arr[i-1]+solve(i,idx-1,arr,dp)+solve(idx+1,j,arr,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
}