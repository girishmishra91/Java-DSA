/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);

    }
    public TreeNode construct(int l,int r,List<Integer> arr){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=construct(l,mid-1,arr);
        root.right=construct(mid+1,r,arr);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int l=0;
        int r=arr.size()-1;
        return construct(l,r,arr);
    }
}