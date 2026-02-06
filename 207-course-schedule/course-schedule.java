class Solution {  
    static boolean ans;
    public void dfs(int i,List<List<Integer>> adj,boolean[] path,boolean[] vis){
        path[i]=true;
        vis[i]=true;
        for(int ele:adj.get(i)){
            if(path[ele]==true){
                ans=false;
                return;
            }
            if(vis[ele]==false) dfs(ele,adj,path,vis);
        }
        path[i]=false;
    }
    public boolean canFinish(int n, int[][] pre) {
        ans=true;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            int a=pre[i][0],b=pre[i][1];
            adj.get(b).add(a);
        }
        boolean[] path=new boolean[n];
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false)dfs(i,adj,path,vis);
        }
        return ans;
        
    }
}