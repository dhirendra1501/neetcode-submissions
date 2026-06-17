class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;
        int visit[][]= new int[n][m];
        Queue<Pair> q= new LinkedList<>();
        int cntFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visit[i][j]=2;
                    q.add(new Pair(i,j,0));
                }
                else{
                    visit[i][j]=0;
                }
                if(grid[i][j]==1)cntFresh++;
            }
        }

        int tm=0;
        int cnt=0;
        int delrow[]={-1,1,0,0};
        int delcol[]={0,0,-1,1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            tm= Math.max(t,tm);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=r+delrow[i];
                int ncol=c+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visit[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    visit[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh)return -1;
        return tm;
    }
}
class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
