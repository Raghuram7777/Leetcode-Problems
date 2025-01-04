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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
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
                l.add(t.val);
            }
            list.add(l);
        }
        List<Integer> fin=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            fin.add((list.get(i)).get(list.get(i).size()-1));
        }
        return fin;
    }
}