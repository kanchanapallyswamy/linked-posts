class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int ans) {
        List<Integer> l=new ArrayList<>();
        if(root==null)return l;
        Map<TreeNode,TreeNode> mp=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode strt=null;
        q.add(root);
        while(q.size()>0){
            TreeNode k=q.remove();
            if(k.val==target.val)strt=k;
            if(k.left!=null){
                q.add(k.left);
                mp.put(k.left,k);
            }
            if(k.right!=null){
                q.add(k.right);
                mp.put(k.right,k);
            }
        } 
        int c=0;
        q.add(strt);
        Set<TreeNode> st=new HashSet<>();
        while(q.size()>0){
            int n=q.size();
            // c++;
            List<Integer> temp=new ArrayList<>();
            while(n-->0){
                TreeNode k=q.remove();
                st.add(k);
                temp.add(k.val);
                if(k.left!=null && !st.contains(k.left))q.add(k.left);
                if(k.right!=null && !st.contains(k.right))q.add(k.right);
                if(mp.get(k)!=null && !st.contains(mp.get(k)))q.add(mp.get(k));
            }
            if(c==ans)return temp;
            c++;
        }
        return l;

    }
    void get_parents(TreeNode root){
        if(root==null)return ;
        Map<TreeNode,TreeNode> mp=new HashMap<>();
    
    }
}