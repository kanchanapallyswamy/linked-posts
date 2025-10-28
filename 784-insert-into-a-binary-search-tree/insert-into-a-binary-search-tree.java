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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
        root=insert(root,val);
        return root;
    }
static TreeNode insert(TreeNode root,int x){
    if(root==null)return new TreeNode(x);
    else if(x<root.val)root.left=insert(root.left,x);
    else root.right=insert(root.right,x);
    return root;
}
}