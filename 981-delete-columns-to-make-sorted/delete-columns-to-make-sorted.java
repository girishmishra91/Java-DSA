class Solution {
    public int minDeletionSize(String[] strs) {
        int cols=strs.length;
        int rows=strs[0].length();
        int count=0;
        for(int j=0;j<rows;j++){
            for(int i=1;i<cols;i++){
                if(strs[i].charAt(j)<strs[i-1].charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}