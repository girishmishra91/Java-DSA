class Solution {
    boolean isBalanced(int[] freq){
        int count=0;
        for(int f:freq){
            if(f>0){
                if(count==0) count=f;
                else if(f!=count) return false;
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(isBalanced(freq)){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}