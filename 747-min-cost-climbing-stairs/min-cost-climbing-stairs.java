class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}


// class Solution {
//     public int minCost(int[] cost,int n,int[] dp){
//         if(n==0||n==1) return cost[n];
//         if(dp[n]!=-1) return dp[n];
//         return dp[n]=cost[n]+Math.min(minCost(cost,n-1,dp),minCost(cost,n-2,dp));
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n=cost.length;
//         int[] dp=new int[n];
//         Arrays.fill(dp,-1);
//         return Math.min(minCost(cost,n-1,dp),minCost(cost,n-2,dp));
//     }
// }