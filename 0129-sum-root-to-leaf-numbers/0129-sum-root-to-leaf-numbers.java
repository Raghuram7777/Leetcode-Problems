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
    List<String> arr=new ArrayList<>();
    String a="";
    public void preorder(TreeNode root,String a){
        if(root==null){
            return;
        }
        a+=root.val;
        if(root.left==null && root.right==null){
            arr.add(a);
        }
        preorder(root.left,a);
        preorder(root.right,a);
    }
    public int sumNumbers(TreeNode root) {
        a="";
        preorder(root,a);
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum+=Integer.parseInt(arr.get(i));
        }
        return sum;
    }
}