class Solution {
        int cnt=0;
    public int maxAreaOfIsland(int[][] a) {
        int max=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==1){
                    fill(a,a.length,a[0].length,i,j);
                    max=Math.max(max,cnt);
                    cnt=0;
                }
            }
        }
        return max;
    }
    int di[]={-1,0,1,0};
    int dj[]={0,1,0,-1};
    void fill(int a[][],int r,int c,int i,int j){
        if(i<0 || j<0 || i>=r || j>=c || a[i][j]!=1)return ;
        a[i][j]=30;
        cnt++;
        for(int k=0;k<4;k++){
            fill(a,r,c,i+di[k],j+dj[k]);
        }
    }
}