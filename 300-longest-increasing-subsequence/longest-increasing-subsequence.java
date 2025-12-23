class Solution {
    private int lowerbound(ArrayList<Integer> ans,int target){
        int low=0;
        int high=ans.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ans.get(mid)==target){
                return mid;
            }
            else if(ans.get(mid)>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }
            else{
                ans.set(lowerbound(ans,nums[i]),nums[i]);
            }
        }
        return ans.size();
    }
}