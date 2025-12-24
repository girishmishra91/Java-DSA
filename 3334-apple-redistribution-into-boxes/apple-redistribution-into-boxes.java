class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n=apple.length;
        int m=capacity.length;
        Arrays.sort(capacity);
        int totalapple=0;
        for(int i=0;i<n;i++){
            totalapple+=apple[i];
        }
        int count=0;
        int i=capacity.length-1;
        while(totalapple>0){
            totalapple-=capacity[i];
            count++;
            i--;
        }
        return count;
    }
}