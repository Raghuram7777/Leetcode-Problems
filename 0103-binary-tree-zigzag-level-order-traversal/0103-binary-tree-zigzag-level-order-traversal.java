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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int flag=0;
        while(!q.isEmpty()){
            List<Integer> l=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode t=q.poll();
                if(t.left!=null){
                    q.offer(t.left);
                }if(t.right!=null){
                    q.offer(t.right);
                }
                if(flag==0){
                l.add(t.val);}
                else{
                    l.add(0,t.val);
                }
            }
            flag=~flag;
            list.add(l);
        }
        return list;
    }
}