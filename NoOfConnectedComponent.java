public class NoOfConnectedComponent {
    class Solution {
        public int findParent(int par[],int x)
        {
            if(par[x]==x)
            return x;
            else
            {
                par[x]=findParent(par,par[x]);
                return par[x];
            }
        }
        public void unionByRank(int par[],int rank[],int u,int v)
        {
            int par_u=findParent(par,u);
            int par_v=findParent(par,v);
    
            if(rank[par_u]==rank[par_v])
            {
                par[par_v]=par[par_u];
                rank[par_u]++;
            }
            else if(rank[par_u]>rank[par_v])
            {
                par[par_v]=par[par_u];
            }
            else if(rank[par_v]>rank[par_u])
            {
                par[par_u]=par[par_v];
            }
        }
        public int makeConnected(int n, int[][] connections) {
            int par[]=new int[n];
            int rank[]=new int[n];
    
            for(int i=0;i<n;i++)
            {
                par[i]=i;
                rank[i]=0;
            }
            int extra=0;
            for(int i=0;i<connections.length;i++)
            {
                int src=connections[i][0];
                int dest=connections[i][1];
    
                if(findParent(par,src)==findParent(par,dest))
                extra++;
                else
                {
                    unionByRank(par,rank,src,dest);
                }
    
            }
            int nc=0;
            for(int i=0;i<n;i++)
            {
                if(par[i]==i)
                nc++;
            }
            if(extra>=nc-1)
            return nc-1;
            else 
            return -1;
        }
    }
}
