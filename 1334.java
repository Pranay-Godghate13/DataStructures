public class 1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int mat[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                mat[i][j]=0;
                else
                mat[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++)
        {
            int row=edges[i][0];
            int col=edges[i][1];
            int edgeWt=edges[i][2];
            mat[row][col]=edgeWt;
            mat[col][row]=edgeWt;
        }

        for(int val=0;val<n;val++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(mat[i][val]!=Integer.MAX_VALUE && mat[val][j]!=Integer.MAX_VALUE)
                    mat[i][j]=Math.min(mat[i][j],mat[i][val]+mat[val][j]);
                }
            }
        }
        int citiesCount[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]<=distanceThreshold)
                count++;
            }
            citiesCount[i]=count;

         }
         int max=Integer.MAX_VALUE;
         int ans=-1;
         for(int i=n-1;i>=0;i--)
         {
            if(citiesCount[i]<max)
            {
                max=citiesCount[i];
                ans=i;
            }
         }
         return ans;

        
    }
}
