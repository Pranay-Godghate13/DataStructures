public class UndirectedCycleBFS {
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int src)
    {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        visited[src]=true;
        
        while(!q.isEmpty())
        {
            Pair remove=q.peek();
            int node=remove.node;
            int par=remove.par;
            q.remove();
            ArrayList<Integer> a=adj.get(node);
            for(int i=0;i<a.size();i++)
            {
                int elem=a.get(i);
                if(visited[elem]==false)
                {
                    q.add(new Pair(elem,node));
                    visited[elem]=true;
                }
                else if(elem!=par)
                return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V=adj.size();
        boolean visited[]=new boolean[V];// O(V)
      
        Solution s=new Solution();
        // s.createGraph(Adj,adj,V);
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                if(s.bfs(adj,visited,i))
                return true;    
            }
            
        }
        return false;
    }
}
class Pair
{
    int node;
    int par;
    Pair(int node,int par)
    {
        this.node=node;
        this.par=par;
    }
}