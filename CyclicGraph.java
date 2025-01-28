import java.util.ArrayList;

public class CyclicGraph {
    public void createGraph(ArrayList<CycleEdge> adj[],int v)
    {
        for(int i=0;i<v;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[0].add(new CycleEdge(0, 1));
        adj[0].add(new CycleEdge(0, 4));
        adj[1].add(new CycleEdge(1, 0));
        adj[1].add(new CycleEdge(1, 2));
        //adj[1].add(new CycleEdge(1, 4));
        adj[2].add(new CycleEdge(2, 1));
        adj[2].add(new CycleEdge(2, 3));
        adj[3].add(new CycleEdge(3, 2));
        adj[4].add(new CycleEdge(4, 0));
        //adj[4].add(new CycleEdge(4, 1));
        adj[4].add(new CycleEdge(4, 5));
        adj[5].add(new CycleEdge(5, 4));
    }
    public boolean isCycle(ArrayList<CycleEdge> adj[],boolean visited[],int v,int p,int curr)
    {
        visited[curr]=true;
        for(int i=0;i<adj[curr].size();i++)
        {
            CycleEdge e=adj[curr].get(i);
            if(visited[e.dest] && p!=e.dest)
            return true;
            if(!visited[e.dest])
            {
                if(isCycle(adj, visited, v, curr, e.dest))
                return true;
            }
            
        }
        return false;
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<CycleEdge> adj[]=new ArrayList[v];
        CyclicGraph cg=new CyclicGraph();
        cg.createGraph(adj, v);
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                if(cg.isCycle(adj,visited,v,-1,i))
                {
                    System.out.println(true);
                    break;
                }
                
            }
        }

    }
}
class CycleEdge
{
    int src;
    int dest;
    public CycleEdge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
    
}
