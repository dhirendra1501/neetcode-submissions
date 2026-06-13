class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int[][] ans=image;
        int initialColor= image[sr][sc];
        dfs(sr,sc,image,initialColor,color,ans);
        return ans;  
    }

    public void dfs(int row,int col,int[][] image,
    int initialColor,int newColor,int[][] ans){
        ans[row][col]=newColor;
        int[] delrow={-1,1,0,0};
        int[] delcol={0,0,-1,1};
        int n= image.length;
        int m= image[0].length;
        for(int i=0;i<4;i++){
            int nrow= row+delrow[i];
            int ncol= col+delcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m
            && image[nrow][ncol]==initialColor && ans[nrow][ncol]!=newColor){
                dfs(nrow,ncol,image,initialColor,newColor,ans);
            }
        }
    }
}