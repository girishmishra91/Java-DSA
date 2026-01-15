class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxhbars=1;
        int maxvbars=1;
        int currmaxhbars=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                currmaxhbars++;
            }else{
                currmaxhbars=1;
            }
            maxhbars=Math.max(maxhbars,currmaxhbars);
        }
        int currmaxvbars=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1){
                currmaxvbars++;
            }
            else{
                currmaxvbars=1;
            }
            maxvbars=Math.max(maxvbars,currmaxvbars);
        }
        int side=Math.min(maxhbars,maxvbars)+1;
        return side*side;
    }
}