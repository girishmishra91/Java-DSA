class Solution {
    public int minDeletionSize(String[] strs) {
        int rows=strs.length;
        int cols=strs[0].length();
        int deletion=0;
        boolean[] alreadySorted=new boolean[rows-1];
        for(int j=0;j<cols;j++){
            boolean deleted=false;
            for(int i=0;i<rows-1;i++){
                if(!alreadySorted [i] && strs[i].charAt(j)>strs[i+1].charAt(j)){
                    deleted=true;
                    deletion++;
                    break;
                }
            }
            if(deleted){
                continue;
            }
            for(int i=0;i<rows-1;i++){
                if(strs[i].charAt(j)<strs[i+1].charAt(j)){
                    alreadySorted[i]= true;
                }
            }
        }
        return deletion;
    }
}