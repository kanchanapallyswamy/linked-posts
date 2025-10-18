class Solution {
    int dj[] = {0,1,0,-1};
    int di[] = {-1,0,1,0};
    public int[][] updateMatrix(int[][] grid) {
        int r = grid.length , c =grid[0].length;
        int ans[][] = new int[r][c];
        boolean visited [][] = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j = 0 ;j <grid[i].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j,0});
                    visited[i][j]=true;
                    ans[i][j]=0;
                }
            }
        }
        while(q.size() >  0){
            var k = q.remove();
            int i = k[0] , j = k[1] , d = k[2];
            for(int kk = 0;kk <4;kk++){
                int ni =di[kk]+i ,nj=dj[kk]+j;
                if(ni>=0 && ni<r && nj>=0 && nj<c && grid[ni][nj]==1 && !visited[ni][nj]){
                    q.add(new int[]{ni,nj,d+1});
                    visited[ni][nj]=true;
                    ans[ni][nj]=d+1;
                }
            }
        }
        
        return ans;
          
    }
}