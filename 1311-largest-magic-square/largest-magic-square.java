class Solution {
    public int largestMagicSquare(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        // row-wise prefix sum
        int[][] rowsum=new int[rows][cols];
        for(int i=0;i<rows;i++){
            rowsum[i][0]=grid[i][0];
            for(int j=1;j<cols;j++){
                rowsum[i][j]=rowsum[i][j-1]+grid[i][j];
            }
        }
        // col-wise prefix sum
        int[][] colsum=new int[rows][cols];
        for(int j=0;j<cols;j++){
            colsum[0][j]=grid[0][j];
            for(int i=1;i<rows;i++){
                colsum[i][j]=colsum[i-1][j]+grid[i][j];
            }
        }

        for(int side=Math.min(rows,cols);side>=2;side--){
            // top left corner of square
            for(int i=0;i+side-1<rows;i++){
                for(int j=0;j+side-1<cols;j++){
                    int target=rowsum[i][j+side-1]-(j>0?rowsum[i][j-1]:0);
                    boolean allsame=true;
                    for(int r=i+1;r<i+side;r++){
                        int rowSum=rowsum[r][j+side-1]-(j>0?rowsum[r][j-1]:0);
                        if(rowSum!=target){
                            allsame=false;
                            break;
                        }
                    }
                    if(!allsame) continue;

                    // check all cols
                    for(int c=j;c<j+side;c++){
                        int colSum=colsum[i+side-1][c]-(i>0?colsum[i-1][c]:0);
                        if(colSum!=target){
                            allsame=false;
                            break;
                        }
                    }
                    if(!allsame) continue;

                    //check diagonal
                    int diag=0;
                    int antidiag=0;
                    for(int k=0;k<side;k++){
                        diag+=grid[i+k][j+k];
                        antidiag+=grid[i+k][j+side-1-k];
                    }
                    if(diag==target&&antidiag==target){
                        return side;
                    }
                }
            }
        }
        return 1;
    }
}