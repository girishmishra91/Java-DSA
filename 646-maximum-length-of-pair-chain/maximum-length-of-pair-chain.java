class Solution {
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int maxl=1;
        int prev=pairs[0][1];
        for(int i=1;i<n;i++){
            if(prev<pairs[i][0]){
                maxl++;
                prev=pairs[i][1];
            }
        }
        return maxl;
    }
}