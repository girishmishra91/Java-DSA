class Solution {
    public int findTheCity(int n, int[][] edges, int Threshold) {
        int[][] path=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) path[i][j]=0;
                else path[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0],v=edges[i][1],w=edges[i][2];
            path[u][v]=w;
            path[v][u]=w;
        }
        //floyd warshall algo
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(i==k) continue;
                for(int j=0;j<n;j++){
                    if(j==k) continue;
                    if(path[i][k]!=Integer.MAX_VALUE && path[k][j]!=Integer.MAX_VALUE){
                        path[i][j]=Math.min(path[i][j],path[i][k]+path[k][j]);
                    }
                }
            }
        }
        int mincity=-1;
        int mincount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(path[i][j]<=Threshold) count++;
            }
            if(count<=mincount){
                mincount=count;
                mincity=i;
}
        }
        return mincity;
    }
}