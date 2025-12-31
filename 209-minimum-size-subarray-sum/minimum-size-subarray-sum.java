class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int minlen=Integer.MAX_VALUE;
        int i=0,j=0,sum=0;
        while(j<n&&sum<target){
            sum+=nums[j++];
        }
        j--;
        while(i<n&&j<n){
            int len=j-i+1;
            if(sum>=target) minlen=Math.min(minlen,len);
            sum-=nums[i];
            i++;j++;
            while(j<n&&sum<target){
                sum+=nums[j++];
            }
            j--;

        }
        if(minlen==Integer.MAX_VALUE) return 0;
        return minlen;
        
    }
}

// Brute Force
// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int n=nums.length;
//         int minlen=Integer.MAX_VALUE;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             int j=i;
//             while(j<n&&sum<target){
//                 sum+=nums[j++];
//             }
//             j--;
//             int len=j-i+1;
//             if(sum>=target) {
//                 minlen=Math.min(minlen,len);
//             }
//         }
//         if(minlen==Integer.MAX_VALUE) return 0;
//         return minlen;
//     }
// }