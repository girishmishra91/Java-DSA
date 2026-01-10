class Solution {
    public int solve(int i,int j,String s1,String s2,int[][] dp){
        if(i==s1.length()&&j==s2.length()) return 0;
        if(i>=s1.length()){
            return dp[i][j]=s2.charAt(j)+solve(i,j+1,s1,s2,dp);
        }
        else if(j>=s2.length()){
            return dp[i][j]=s1.charAt(i)+solve(i+1,j,s1,s2,dp);
        }
        if(s1.charAt(i)==s2.charAt(j)) return solve(i+1,j+1,s1,s2,dp);
        if(dp[i][j]!=-1) return dp[i][j];
        int del_s1_i=s1.charAt(i)+solve(i+1,j,s1,s2,dp);
        int del_s2_j=s2.charAt(j)+solve(i,j+1,s1,s2,dp);
        return dp[i][j]=Math.min(del_s1_i,del_s2_j);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,s1,s2,dp);
    }
}