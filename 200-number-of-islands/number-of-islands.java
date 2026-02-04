class Solution {
    public void dfa(int i,int j,char[][] grid,boolean[][] vis){
        int n=grid.length,m=grid[0].length;
        vis[i][j]=true;
        if(i-1>=0&&grid[i-1][j]=='1'&&vis[i-1][j]==false){
            dfa(i-1,j,grid,vis);
        }
        if((i+1)<=n-1&&grid[i+1][j]=='1'&&vis[i+1][j]==false){
            dfa(i+1,j,grid,vis);
        }
        if(j-1>=0&&grid[i][j-1]=='1'&&vis[i][j-1]==false){
            dfa(i,j-1,grid,vis);
        }
        if((j+1)<=m-1&&grid[i][j+1]=='1'&&vis[i][j+1]==false){
            dfa(i,j+1,grid,vis);
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&& vis[i][j]==false){
                    dfa(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
}