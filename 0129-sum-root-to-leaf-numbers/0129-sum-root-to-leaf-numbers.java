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
    int sum=0;
    public void preorder(TreeNode root,int rsum){
        if(root==null){
            return;
        }
        rsum = rsum * 10 + root.val;
        if(root.left==null && root.right==null){
            sum+=rsum;
        }
        preorder(root.left,rsum);
        preorder(root.right,rsum);
    }
    public int sumNumbers(TreeNode root) {
        sum=0;
        preorder(root,0);        
        return sum;
    }
}