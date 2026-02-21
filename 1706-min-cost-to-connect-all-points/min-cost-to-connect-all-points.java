class Solution {
    public class Triplet implements Comparable <Triplet>{
        int node ;
        int parent;
        int weight;
        Triplet(int node,int parent,int weight){
            this.node=node;
            this.parent=parent;
            this.weight=weight;
        }
        public int compareTo(Triplet t){
            if(this.weight==t.weight) return Integer.compare(this.node,t.node);
            return Integer.compare(this.weight,t.weight);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;   
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        boolean[] vis=new boolean[n];
        int sum=0;
        //vis[0]=true;
        while(pq.size()>0){
            Triplet top=pq.remove();
            int node=top.node,parent=top.parent,weight=top.weight;
            if(vis[node]==true) continue;
            vis[node]=true;
            sum+=weight;
            for(int i=0;i<n;i++){
                if(i==node||i==parent) continue;
                if(vis[i]==true) continue;
                int x1=points[node][0],y1=points[node][1];
                int x2=points[i][0],y2=points[i][1];
                int mandist=Math.abs(x2-x1)+Math.abs(y2-y1);
                pq.add(new Triplet(i,node,mandist));
            }
        }
        return sum;

    }
}