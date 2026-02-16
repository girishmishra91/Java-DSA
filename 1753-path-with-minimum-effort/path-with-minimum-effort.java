class Solution {
    public class Triplet implements Comparable<Triplet>{
        int row, col, effort;
        Triplet(int row,int col,int effort){
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
        public int compareTo(Triplet t){
            if(this.effort==t.effort) return this.col-t.col;
            return this.effort-t.effort;
        } 
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length,m=heights[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=Integer.MAX_VALUE;
            }
        }
        ans[0][0]=0;
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(pq.size()>0){
            Triplet top=pq.remove();
            int row=top.row;
            int col=top.col;
            int effort=top.effort;
            if(row>0){//up
                int e=Math.abs(heights[row][col]-heights[row-1][col]);
                e=Math.max(e,effort);
                if(e<ans[row-1][col]){
                    ans[row-1][col]=e;
                    pq.add(new Triplet(row-1,col,e));
                }
            }
            if(col>0){//left
                int e=Math.abs(heights[row][col]-heights[row][col-1]);
                e=Math.max(e,effort);
                if(e<ans[row][col-1]){
                    ans[row][col-1]=e;
                    pq.add(new Triplet(row,col-1,e));
                }
            }
            if(row<n-1){ // down
                int e=Math.abs(heights[row][col]-heights[row+1][col]);
                e=Math.max(e,effort);
                if(e<ans[row+1][col]){
                    ans[row+1][col]=e;
                    pq.add(new Triplet(row+1,col,e));
                }
            }
            if(col<m-1){  //right
                int e=Math.abs(heights[row][col]-heights[row][col+1]);
                e=Math.max(e,effort);
                if(e<ans[row][col+1]){
                    ans[row][col+1]=e;
                    pq.add(new Triplet(row,col+1,e));
                }
            }
        }
        return ans[n-1][m-1];

    }
}