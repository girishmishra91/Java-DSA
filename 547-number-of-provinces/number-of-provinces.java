class Solution {
    private static void bfs(int i,int[][] adj,boolean[] vis){
        Queue<Integer>qu=new LinkedList<>();
        qu.offer(i);
        vis[i]=true;
        while(!qu.isEmpty()){
            int top=qu.poll();
            for(int j=0;j<adj.length;j++){
                if(adj[top][j]==1&&vis[j]==false){
                    qu.add(j);
                    vis[j]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        int count=0;
        boolean [] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,adj,vis);
                count++;
            }
        }
        return count;
    }
}