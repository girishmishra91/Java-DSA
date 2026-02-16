class Solution {
    public class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int effort;
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
        int[] r={-1,0,1,0};
        int[] c={0,1,0,-1};
        while(pq.size()>0){
            Triplet top=pq.remove();
            int row=top.row;
            int col=top.col;
            int effort=top.effort;
            if(row==n-1&&col==m-1) break;
            for(int i=0;i<4;i++){
                int newrow=row+r[i];
                int newcol=col+c[i];
                if(newrow<0||newcol<0||newrow>=n||newcol>=m) continue;
                int e=Math.abs(heights[row][col]-heights[newrow][newcol]);
                e=Math.max(e,effort);
                if(e<ans[newrow][newcol]){
                    ans[newrow][newcol]=e;
                    pq.add(new Triplet(newrow,newcol,e));
                }
            }
        }
        return ans[n-1][m-1];

    }
}