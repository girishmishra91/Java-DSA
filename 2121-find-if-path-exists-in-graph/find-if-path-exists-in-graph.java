class Solution {
    private static void bfs(int start,List<List<Integer>> adj,boolean[]vis){
        Queue<Integer> qu=new LinkedList<>();
        qu.add(start);
        vis[start]=true;
        while(qu.size()>0){
            int front=qu.remove();
            for(int ele:adj.get(front)){
                if(!vis[ele]){
                    qu.add(ele);
                    vis[ele]=true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>();
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0],b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis=new boolean[n];
        vis[start]=true;
        bfs(start,adj,vis);
        return vis[end];
    }
}