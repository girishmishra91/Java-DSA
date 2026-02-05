class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            int a=pre[i][0],b=pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        //kahns algo
        Queue<Integer> qu=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) qu.add(i);
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
        if(ans.size()==n) return true;
        else return false;
    }
}