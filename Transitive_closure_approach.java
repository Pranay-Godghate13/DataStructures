class Solution{
    static void dfs(int row,int col,int graph[][],boolean visited[],boolean matt[][])
    {
        visited[col]=true;
        matt[row][col]=true;
        for(int i=0;i<graph.length;i++)
        {
            if(!visited[i] && graph[col][i]==1)
            dfs(row,i,graph,visited,matt);
        }
    }
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
        boolean matt[][]=new boolean[N][N];
        for(int i=0;i<N;i++)
        {
            dfs(i,i,graph,new boolean[N],matt);
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            ArrayList<Integer> a=new ArrayList<>();
            for(int j=0;j<N;j++)
            {
                if(matt[i][j])
                a.add(1);
                else
                a.add(0);
            }
            adj.add(a);
        }
        return adj;
    }
}