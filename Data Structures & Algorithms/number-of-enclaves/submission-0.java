class Solution {
    public int numEnclaves(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int[][] visit= new int[n][m];
        Queue<Node> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                    q.add(new Node(i,j));
                    visit[i][j]=1;
                    }
                }
            }
        }
        int[] delrow = {-1,1,0,0};
        int [] delcol = {0,0,-1,1};
        while(!q.isEmpty()){
            int row= q.peek().row;
            int col= q.peek().col;
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol= col+delcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && visit[nrow][ncol]==0){
                    q.add(new Node(nrow,ncol));
                    visit[nrow][ncol]=1;
                }
            }

        }
         int result=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visit[i][j]==0){
                    result++;
                }
            }
         }
         return result;
    }
}
class Node{
    int row;
    int col;
    Node(int row,int col){
        this.row=row;
        this.col=col;
    }
}