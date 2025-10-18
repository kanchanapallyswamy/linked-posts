class Solution {
    public int totalNQueens(int n) {
       return find(n); 
    }
static int find(int n){
       char a[][]=new char[n][n];
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length;j++)
                a[i][j]='.';
        List<List<String>> lst=new ArrayList<>();
        find(a,0,lst);
        return lst.size();
    }
static void find( char a[][] , int r, List<List<String>> lst){
        if(r==a.length){
                lst.add(construct(a));
                return ;
        }
        for(int j=0;j<a.length;j++){
            if(isvalid(a,r,j)){
                a[r][j]='Q';
                find(a,r+1,lst);
                a[r][j]='.';
            }
        }
}
    static boolean isvalid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
     static List<String> construct(char[][] board) {
        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }
}