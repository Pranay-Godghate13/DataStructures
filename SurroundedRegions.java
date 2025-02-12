public class SurroundedRegions {
    public void dfs(char board[][],int visited[][],int row,int col)
    {
        visited[row][col]=1;
        int m=board.length;
        int n=board[0].length;

        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,1};

        for(int i=0;i<4;i++)
        {
            int nrow=row+drow[i];
            int ncol=col+dcol[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && board[nrow][ncol]=='O' && visited[nrow][ncol]!=1)
            {
                dfs(board,visited,nrow,ncol);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        // char copy[][]=new char[m][n];
        
        // for(int i=0;i<m;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         copy[i][j]=board[i][j];
        //     }
        // }

        int visited[][]=new int[m][n];
        Solution s=new Solution();
        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O' && visited[0][i]!=1)
            {
                s.dfs(board,visited,0,i);
            }
            if(board[m-1][i]=='O' && visited[m-1][i]!=1)
            {
                s.dfs(board,visited,m-1,i);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O' && visited[i][0]!=1)
            {
                s.dfs(board,visited,i,0);
            }
            if(board[i][n-1]=='O' && visited[i][n-1]!=1)
            {
                s.dfs(board,visited,i,n-1);
            }
        }
            

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && visited[i][j]!=1)
                board[i][j]='X';
            }
        }
    }
}
