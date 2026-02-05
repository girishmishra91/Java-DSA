class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] inplace=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            int a=pre[i][0],b=pre[i][1];
            adj.get(b).add(a);
            inplace[a]++;
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inplace[i]==0) qu.add(i);
        }
        while(qu.size()>0){
            int front=qu.remove();
            ans.add(front);
            for(int ele:adj.get(front)){
                inplace[ele]--;
                if(inplace[ele]==0){
                    qu.add(ele);
                }
            }
        }
        int[] result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        if(ans.size()!=n) return new int[0];
        return result;
    }
}