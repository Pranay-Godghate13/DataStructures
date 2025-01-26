import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public void createGraph(ArrayList<TopoEdge> adj[],int v)
    {
        for(int i=0;i<v;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[2].add(new TopoEdge(2, 3));
        adj[3].add(new TopoEdge(3, 1));
        adj[4].add(new TopoEdge(4, 0));
        adj[4].add(new TopoEdge(4, 1));
        adj[5].add(new TopoEdge(5, 0));
        adj[5].add(new TopoEdge(5, 2));
    }
    public void topoSort(ArrayList<TopoEdge> adj[],boolean visited[],Stack<Integer> st,int curr)
    {
        visited[curr]=true;
        for(int i=0;i<adj[curr].size();i++)
        {
            TopoEdge e=adj[curr].get(i);
            if(!visited[e.dest])
            {
                topoSort(adj, visited, st, e.dest);
            }
        }
        st.push(curr);
    }
    public static void main(String args[])
    {
        int v=6;
        ArrayList<TopoEdge> adj[]=new ArrayList[v];
        TopologicalSort ts=new TopologicalSort();
        ts.createGraph(adj,v);
        boolean visited[]=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                ts.topoSort(adj,visited,st,i);
            }
        }
        while(!st.isEmpty())
        {
            System.out.print(st.pop());
        }
    }
}
class TopoEdge
{
    int src;
    int dest;
    public TopoEdge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
    
}