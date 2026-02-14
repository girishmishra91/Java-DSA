class Solution {
    public double solve(int poured,int i,int j,double[][] dp){
        if(i<0||j<0||i<j)return 0.0;
        if(i==0&&j==0) return poured;
        if(dp[i][j]!=-1.0) return dp[i][j];
        double left=(solve(poured,i-1,j-1,dp)-1)/2.0;
        double right=(solve(poured,i-1,j,dp)-1)/2.0;
        left=Math.max(0,left);
        right=Math.max(0,right);
        return dp[i][j]=left+right;
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp=new double[101][101];
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                dp[i][j]=-1;
            }
        }
        return Math.min(1.0,solve(poured,query_row,query_glass,dp));
    }
}