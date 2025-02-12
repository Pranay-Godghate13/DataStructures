public class 01Matrix {
    public void bfs(int mat[][],int visited[][],int distance[][],Queue<Pair> q,int m,int n)
    {
        while(!q.isEmpty())
        {
            Pair remove=q.peek();
            int row=remove.row;
            int col=remove.col;
            int d=remove.dist;
            q.remove();
            distance[row][col]=d;

            int drow[]={-1,0,1,0};
            int dcol[]={0,-1,0,1};

            for(int i=0;i<4;i++)
            {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];

                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]==0 && mat[nrow][ncol]==1)
                {
                    q.add(new Pair(nrow,ncol,d+1));
                    visited[nrow][ncol]=1;
                }
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        Solution s=new Solution();
        int m=mat.length;
        int n=mat[0].length;
        int visited[][]=new int[m][n];
        int distance[][]=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(i,j,mat[i][j]));
                    visited[i][j]=1;
                }
                
            }
        }
        s.bfs(mat,visited,distance,q,m,n);
        return distance;
    }
}
class Pair
{
    int row;
    int col;
    int dist;
    Pair(int row,int col,int dist)
    {
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}