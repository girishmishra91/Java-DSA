class Solution {
    public static void reverse(int[] nums,int  left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        if(n==0) return;
            reverse(nums,0,n-k-1);
            reverse(nums,n-k,n-1);
            reverse(nums,0,n-1);
        
    }
}