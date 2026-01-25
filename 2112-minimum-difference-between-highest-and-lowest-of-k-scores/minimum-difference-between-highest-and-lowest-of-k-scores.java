class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=k-1;
        while(j<n){
            int maxel=nums[j];
            int minel=nums[i];
            min=Math.min(min,maxel-minel);
            i++;
            j++;
        }
        return min;
    }
}