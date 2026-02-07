class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int[] left_b=new int[n];
        int[] right_a=new int[n];
        int countb=0;
        for(int i=0;i<n;i++){
            left_b[i]=countb;
            if(s.charAt(i)=='b'){
                countb++;
            }
        }
        int counta=0;
        for(int i=n-1;i>=0;i--){
            right_a[i]=counta;
            if(s.charAt(i)=='a'){
                counta++;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,left_b[i]+right_a[i]);
        }
        return min;
    }
}