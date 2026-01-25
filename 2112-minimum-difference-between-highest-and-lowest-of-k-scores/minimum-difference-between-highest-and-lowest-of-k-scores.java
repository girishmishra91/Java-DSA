class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        int mindiff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i=0;
        int j=k-1;
        while(j<n){
            int minel=nums[i];
            int maxel=nums[j];
            mindiff=Math.min(mindiff,maxel-minel);
            i++;
            j++;
        }
        return mindiff;

    }
}