class Solution {
    public boolean dfs(int graph[][],int curr,int col,int color[])
    {
        color[curr]=col;
        for(int i=0;i<graph[curr].length;i++)
        {
            if(color[graph[curr][i]]==-1)
            {
                if(dfs(graph,graph[curr][i],1-col,color)==false)
                return false;
            }
            else
            {
                if(color[graph[curr][i]]==col)
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int N=graph.length;
        int color[]=new int[N]; //O(N)
        for(int i=0;i<N;i++)
        {
            color[i]=-1;
        }
        int m=N;
        int n=graph[0].length;
        for(int i=0;i<m;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(graph,i,0,color)==false)
                return false;
            }
        }
        return true;
    }
}