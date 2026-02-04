class Solution {
    private static void bfs(int i,List<List<Integer>> adj,boolean[] vis){
        Queue<Integer> qu=new LinkedList<>();
        qu.add(i);
        vis[i]=true;
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
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n=adj.size();
        boolean[] vis=new boolean[n];
        vis[0]=true;
        bfs(0,adj,vis);
        for(boolean ele:vis){
            if(ele==false) return false;
        }
        return true;
    }
}