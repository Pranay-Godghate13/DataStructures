import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DirectedCyclic {
    public void createGraph(ArrayList<Edge2> adj[],int v)
    {
        for(int i=0;i<v;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[0].add(new Edge2(0, 1));
        adj[1].add(new Edge2(1, 2));
        adj[1].add(new Edge2(1, 3));
        adj[2].add(new Edge2(2, 3));
        // adj[3].add(new Edge2(3, 1));
    }

    
    public boolean findCycle(ArrayList<Edge2> adj[],boolean visited[],boolean recStack[],int curr)
    {
        visited[curr]=true;
        recStack[curr]=true;
        int length=adj[curr].size();
        for(int i=0;i<length;i++)
        {
            Edge2 e=adj[curr].get(i);     
            if(recStack[e.dest]==true)
            return true;
            else
            {
                if(!visited[e.dest])
                if(findCycle(adj, visited, recStack, e.dest))
                return true; 
                
            }
            
        }
        recStack[curr]=false;
        
        return false;

    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge2> adj[]=new ArrayList[v];
        DirectedCyclic dc=new DirectedCyclic(); 
        dc.createGraph(adj,v);
        boolean visited[]=new boolean[v];
        boolean recStack[]=new boolean[v];
        boolean ans=dc.findCycle(adj,visited,recStack,0);
        System.out.println(ans);
    }
}
class Edge2
{
    int src;
    int dest;
    public Edge2(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
    
}