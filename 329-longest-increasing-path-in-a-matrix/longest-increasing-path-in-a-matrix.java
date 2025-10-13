class Solution {
    int[] di = { -1, 0, 1, 0 };
    int[] dj = { 0, 1, 0, -1 };
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] indegree = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < 4; k++) {
                    int ni = di[k] + i, nj = dj[k] + j;
                    if (ni >= 0 && nj >= 0 && ni < r && nj < c && matrix[ni][nj] < matrix[i][j])
                        indegree[i][j]++;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < r;i++)
            for(int j = 0 ; j < c ;j++)
                if(indegree[i][j] == 0)
                    q.add(new int[]{i,j});
        int len = 0;
        while(q.size() > 0 ){
            int n = q.size();
            len++;
            while(n-->0){
                int rem[] = q.remove();
                int ii = rem[0] , jj = rem[1];
                  for (int k = 0; k < 4; k++) {
                int ni = di[k] + ii, nj = dj[k] + jj;
                    if (ni >= 0 && nj >= 0 && ni < r && nj < c && matrix[ni][nj] > matrix[ii][jj]){
                        indegree[ni][nj]--;
                        if(indegree[ni][nj]==0)
                            q.add(new int[]{ni,nj});
                    }
            }

        }
        }
        return len;

    }
}