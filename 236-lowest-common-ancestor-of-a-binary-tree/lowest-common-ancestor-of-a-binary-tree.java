/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l=new ArrayList<>();
        List<TreeNode> r=new ArrayList<>();
        TreeNode k=null;
        l=helper(root,p);
        r=helper(root,q);
        for(int i=0;i<Math.min(l.size(),r.size());i++){
            if(l.get(i)==r.get(i))k=l.get(i);
            else break ;
        }
        return k;
    }
    List<TreeNode> helper(TreeNode root,TreeNode x){
        List<TreeNode> l=new ArrayList<>();
        if(root==null)return l;
        l.add(root);
       boolean found=help(root,x,l);
       if(found)return l;
       else return l;

    }
    boolean help(TreeNode root,TreeNode x,List<TreeNode> l){
        if(root.val==x.val)return true;
        if(root.left!=null){
            l.add(root.left);
            boolean found=help(root.left,x,l);
            if(found)return true;
            else l.remove(l.size()-1);
        }
         if(root.right!=null){
            l.add(root.right);
            boolean found=help(root.right,x,l);
            if(found)return true;
            else l.remove(l.size()-1);
        }
        return false;
    }
}