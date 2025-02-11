//Space complexity-O(nxm)
//Time Complexity-O(nxm)

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int visited[][]=new int[grid.length][grid[0].length];
        int cnt=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else 
                visited[i][j]=0;

                if(grid[i][j]==1)
                cnt++;
            }
        }
        int drow[]={-1,0,1,0};
        int dcol[]={0,-1,0,+1};
        int t=0;
        int cntFresh=0;
        while(!q.isEmpty())
        {
            Pair remove=q.peek();
            int row=remove.row;
            int col=remove.col;
            int time=remove.time;
            t=Math.max(t,time);
            q.remove();

            for(int i=0;i<4;i++)
            {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && visited[nrow][ncol]==0 && grid[nrow][ncol]==1)
                {
                    q.add(new Pair(nrow,ncol,time+1));
                    visited[nrow][ncol]=2;
                    cntFresh++;
                }
            }

        }
        if(cnt!=cntFresh)
        return -1;
        else return t;

    }
}
class Pair
{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time)
    {
        this.row=row;
        this.col=col;
        this.time=time;
    }
}