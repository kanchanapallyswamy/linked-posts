class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> outer=new ArrayList<>();
        if(root==null)return outer;
        List<Integer> inner=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node k=q.remove();
            if(k!=null){
                inner.add(k.val);
               for(int i=0;i<k.children.size();i++){
                q.add(k.children.get(i));
               }
            }
            else{
                outer.add(inner);
                inner=new ArrayList<>();
                if(q.isEmpty())break;
                q.add(null);
            }
        }
        return outer;
    

        
    }
}