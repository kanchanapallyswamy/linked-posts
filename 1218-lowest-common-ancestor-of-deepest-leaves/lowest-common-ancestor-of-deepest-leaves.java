class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null)return null;
        List<List<Integer>> outer=new ArrayList<>();
        List<Integer> inner=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
       outer= paths(root,inner,outer);
       int max=0;
       for(var i:outer)max=Math.max(max,i.size());
       for(var i:outer){
        if(i.size()==max){
            l.add(i.get(i.size()-1));
        }
       }
       if(l.size()==1)return new TreeNode(l.get(0));
        TreeNode nn=lowestCommonAncestor(root,new TreeNode(l.get(0)),new TreeNode(l.get(l.size()-1)));
       Queue<TreeNode> q=new LinkedList<>();
       q.add(root);
       while(q.size()>0){
        var p=q.remove();
        if(p==nn){
            return p;
        }
        if(p.left!=null)q.add(p.left);
        if(p.right!=null)q.add(p.right);
       }

       return nn;

    }
   
    List<List<Integer>> paths(TreeNode r,List<Integer> path, List<List<Integer>> allpaths){
    if(r==null)return allpaths;
     path.add(r.val);
       helper(r,path,allpaths);
       return allpaths;
}
void helper(TreeNode r,List<Integer> path, List<List<Integer>> allpaths){
        if(r.left==null && r.right==null){
           // path.add(r.val);
            allpaths.add(new ArrayList<>(path));
        }

        if(r.left!=null){
            path.add(r.left.val);
            helper(r.left,path,allpaths);
            path.remove(path.size()-1);
        }

        if(r.right!=null){
            path.add(r.right.val);
            helper(r.right,path,allpaths);
            path.remove(path.size()-1);
        }
    }
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