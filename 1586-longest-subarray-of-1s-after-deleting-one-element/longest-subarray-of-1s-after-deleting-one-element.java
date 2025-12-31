class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int i=0,j=0;
        int z=0;
        for(int ele:nums){
            if(ele==0) z++;
        }
        if(z==0)  return n-1;
        int zeroes=0,maxlen=0;
        while(i<n&&nums[i]==0){
            i++;
        }
        j=i;
        while(j<n){
            if(nums[j]==1) j++;
            else{
                if(zeroes==0){
                    j++;
                    zeroes++;
                }else{
                    int len=j-i-1;
                    maxlen=Math.max(len,maxlen);
                    j++;
                    while(i<n&&nums[i]==1){
                        i++;
                    }
                    i++;
                }
            }

        }
        if(zeroes==0) return j-i;
        int len=j-i-1;
        maxlen=Math.max(maxlen,len);
        return maxlen;

    }
}