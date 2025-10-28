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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> outer=new ArrayList<>();
         List<Integer> inner=new ArrayList<>();
        if(root==null)return outer;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode k=q.remove();
            if(k!=null){
                inner.add(k.val);
                if(k.left!=null)q.add(k.left);
                if(k.right!=null)q.add(k.right);
            }
            else{
                outer.add(func(inner));
                inner=new ArrayList<>();
                if(q.isEmpty())break;
                q.add(null);
            }
        }
        return outer;
    }
    static int func(List<Integer> lst){
        Collections.sort(lst,Collections.reverseOrder());
        return lst.get(0);
    }
}