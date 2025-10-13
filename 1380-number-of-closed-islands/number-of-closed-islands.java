class Solution {
    int di[] = { -1, 0, 1, 0 };
    int dj[] = { 0, 1, 0, -1 };
    public int closedIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < r; i++) 
            for (int j = 0; j < c; j++) 
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1)
                   if(grid[i][j]==0) 
                    bfs(grid, i, j, r, c);
        for (int i = 0; i < r; i++) 
            for (int j = 0; j < c; j++) 
                if (grid[i][j] == 0) {
                    cnt++;
                    bfs(grid, i, j, r, c);
                }
        return cnt;
    }
    void bfs(int[][] grid, int si, int sj, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { si, sj });
        grid[si][sj]=1;
        while (q.size() > 0) {
            int rem[] = q.poll();
            int ri = rem[0], ci = rem[1];
            for (int k = 0; k < 4; k++) {
                int ni = ri + di[k], nj = ci + dj[k];
                if (ni >= 0 && nj >= 0 && ni < r && nj < c && grid[ni][nj] == 0) {
                    q.add(new int[] { ni, nj });
                    grid[ni][nj] = 1;
                }
            }
        }
        return;
    }
}