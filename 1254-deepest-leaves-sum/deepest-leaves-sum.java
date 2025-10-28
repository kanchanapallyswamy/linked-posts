class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null)return 0;
        Map<Integer,List<Integer>> map  = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        map.put(0,new ArrayList<>());
        map.get(0).add(root.val);
        int max = 0;
        while(!q.isEmpty()){
            Pair f = q.poll();
            int depth = f.depth+1;
            if(f.node.left != null){
                q.add(new Pair(f.node.left,depth));
                map.putIfAbsent(depth,new ArrayList<>());
                map.get(depth).add(f.node.left.val);
                max = Math.max(max,depth);
            }
            if(f.node.right != null){
                q.add(new Pair(f.node.right,depth));
                map.putIfAbsent(depth,new ArrayList<>());
                map.get(depth).add(f.node.right.val);
                max = Math.max(max,depth);
            }
        }
        int ans = 0;
        for(int i:map.get(max)) ans+=i;
        return ans;
    }
    class Pair{
        TreeNode node;
        int depth;
        public Pair(TreeNode node,int depth){
            this.depth = depth;
            this.node = node;
        }
    }
}