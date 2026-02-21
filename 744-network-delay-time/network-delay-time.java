class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] ans=new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<times.length;j++){
                int u=times[j][0],v=times[j][1],w=times[j][2];
                if(ans[u]!=Integer.MAX_VALUE && ans[u]+w<ans[v]){
                    ans[v]=ans[u]+w;
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(ans[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,ans[i]);
        }
        return max;
    }
}