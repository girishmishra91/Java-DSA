class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    private  void bfs(int i,int j,char[][] grid,boolean[][] vis){
        int n=grid.length,m=grid[0].length;
        Queue<Pair> qu=new LinkedList<>();
        qu.add(new Pair(i,j));
        while(qu.size()>0){
            Pair front=qu.remove();
            int row=front.row,col=front.col;
            //top->row-1,col
            if(row>0){
                if(vis[row-1][col]==false&&grid[row-1][col]=='1'){
                    qu.add(new Pair(row-1,col));
                    vis[row-1][col]=true;
                }
            }
            //bottom->row+1,col
            if((row+1)<n){
                if(vis[row+1][col]==false&&grid[row+1][col]=='1'){
                    qu.add(new Pair(row+1,col));
                    vis[row+1][col]=true;
                }
            }
            //left->row,col-1
            if(col>0){
                if(vis[row][col-1]==false&&grid[row][col-1]=='1'){
                    qu.add(new Pair(row,col-1));
                    vis[row][col-1]=true;
                }
            }
            //right->row,col+1
            if((col+1)<m){
                if(vis[row][col+1]==false&&grid[row][col+1]=='1'){
                    qu.add(new Pair(row,col+1));
                    vis[row][col+1]=true;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int count=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&vis[i][j]==false){
                    bfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
}