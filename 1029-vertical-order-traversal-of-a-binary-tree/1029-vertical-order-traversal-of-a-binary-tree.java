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
    public void preorder(TreeNode root,TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> tm,int hd,int level){
        if(root==null){return;}
        if(!tm.containsKey(hd)){
            tm.put(hd,new TreeMap<>());
        }
        if(!tm.get(hd).containsKey(level)){
            tm.get(hd).put(level,new ArrayList<>());
        }
        tm.get(hd).get(level).add(root.val);
        preorder(root.left,tm,hd-1,level+1);
        preorder(root.right,tm,hd+1,level+1);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> tm=new TreeMap<>();
        preorder(root,tm,0,0);
        List<List<Integer>> arr=new ArrayList<>();
        for(TreeMap<Integer,ArrayList<Integer>> map:tm.values()){
            List<Integer> vertical=new ArrayList<>();
            for(ArrayList<Integer> l:map.values()){
                Collections.sort(l);
                vertical.addAll(l);
            }
        arr.add(vertical);
        }
        return arr;
    }

}