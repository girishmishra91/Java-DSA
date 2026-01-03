class Solution {
    public int numOfWays(int n) {
        int MOD=1_000_000_007;
        long same=6,diff=6;
        for(int i=2;i<=n;i++){
            long newsame=(same*3+diff*2)%MOD;
            long newdiff=(same*2+diff*2)%MOD;
            same=newsame;
            diff=newdiff;
        }
        return (int)((same+diff)%MOD);
    }
}