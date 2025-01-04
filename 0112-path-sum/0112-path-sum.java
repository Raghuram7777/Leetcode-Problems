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
    boolean flag=false;
    public void preOrder(TreeNode root,int rsum,int targetSum){
        if(root==null)return;
        rsum = rsum + root.val;
        if(root.left==null && root.right==null){
        if(rsum==targetSum){flag=true;return;}}
        preOrder(root.left,rsum,targetSum);
        preOrder(root.right,rsum,targetSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        preOrder(root,0,targetSum);
        return flag;
    }
}