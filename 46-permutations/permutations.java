class Solution {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void helper(int[] nums, int idx, List<List<Integer>> ans) {

        // base case
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            ans.add(temp);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            helper(nums, idx + 1, ans);
            swap(nums, idx, i); // backtrack
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }
}
