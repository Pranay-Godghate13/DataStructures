//Time Complexity= O(V^2)+V*O(V+E)=O(V^2).
//Space Complexity=O(V+E)
class Solution {
    public void adjacencyList(ArrayList<Integer> adj[],int[][] isConnected,int V)
    {
        //Create the adjacency list.
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>(); // O(V)
        }
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                
                if(isConnected[i][j]==1 && i!=j) // V^2
                adj[i].add(j);
                
            }
        }
        // for(int i=0;i<V;i++)
        // {
        //     System.out.print(i+"--->");
        //     for(int j=0;j<V;j++)
        //     {
        //         System.out.print(adj[i].get(j));
        //     }
        //     System.out.println();
        // }
    }
    public void dfs(ArrayList<Integer> adj[],int curr,int V,boolean visited[])
    {
        if(visited[curr])
        return;

        visited[curr]=true;
        for(int i=0;i<adj[curr].size();i++)
        {
            int v=adj[curr].get(i);
            if(visited[v]==false)
            dfs(adj,v,V,visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        //1. Convert into adjacency list.
        //2. Apply DFS or BFS with visited loop in main function.
        //3. Counter to count in visited loop.
        int V=isConnected.length; // constant time 
        ArrayList<Integer> adj[]=new ArrayList[V]; //constant time 
        Solution s=new Solution();// constant time
        s.adjacencyList(adj,isConnected,V); // O(V^2)
        boolean visited[]=new boolean[V];
        //To count no of provinces
        int ans=0;
        for(int i=0;i<V;i++)   
        {
            if(visited[i]==false)
            {
                dfs(adj,i,V,visited); // O(V+E)
                ans++;
            }
        }
        return ans;
    }
}