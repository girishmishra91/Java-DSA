class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        long sum=0;
        int maxsum=Integer.MAX_VALUE;
        int count_neg=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum=sum+Math.abs(matrix[i][j]);
                if(matrix[i][j]<0){
                    count_neg++;
                }
                maxsum=Math.min(maxsum,Math.abs(matrix[i][j]));
            }
        }
        if(count_neg%2!=0){
            return sum-2*maxsum;
        }
        return sum;
    }
}