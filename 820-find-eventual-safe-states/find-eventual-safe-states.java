class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int ele:graph[i]){
                adj.get(ele).add(i);
                indegree[i]++;
            }
        }
        //kahn algo
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                qu.add(i);
            }
        }
        while(qu.size()>0){
            int front=qu.remove();
            ans.add(front);
            for(int ele:adj.get(front)){
                indegree[ele]--;
                if(indegree[ele]==0){
                    qu.add(ele);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}