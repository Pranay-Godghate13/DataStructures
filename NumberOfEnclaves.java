public class NumberOfEnclaves {
    public void dfs(int grid[][],int visited[][],int row,int col)
    {
        visited[row][col]=1;
        int m=grid.length;
        int n=grid[0].length;
        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,1};

        for(int i=0;i<4;i++)
        {
            int nrow=row+drow[i];
            int ncol=col+dcol[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && visited[nrow][ncol]==0)
            {
                dfs(grid,visited,nrow,ncol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        // mark the land cell visited which are at the boundary.
        // count which are land cell and unvisited.
        int m=grid.length;
        int n=grid[0].length;

        int visited[][]=new int[m][n];

        //check 1st and last row, here column changes and row index remains 0 and m-1
        Solution s=new Solution();
        for(int i=0;i<n;i++)
        {
            if(grid[0][i]==1 && visited[0][i]==0)
            s.dfs(grid,visited,0,i);

            if(grid[m-1][i]==1 && visited[m-1][i]==0)
            s.dfs(grid,visited,m-1,i);

        }
        //check 1st and n-1 column and row index changes between 0 and m-1
        for(int i=0;i<m;i++)
        {
            if(grid[i][0]==1 && visited[i][0]==0)
            s.dfs(grid,visited,i,0);

            if(grid[i][n-1]==1 && visited[i][n-1]==0)
            s.dfs(grid,visited,i,n-1);
        }
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1 && visited[i][j]==0)
                count++;
            }
        }
        return count;
    }
}
