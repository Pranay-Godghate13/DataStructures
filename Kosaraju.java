import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {
    public void createGraph(ArrayList<KEdge> adj[],int V)
    {
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }

        adj[0].add(new KEdge(0, 3));
        adj[0].add(new KEdge(0, 2));
        adj[1].add(new KEdge(1, 0));
        adj[2].add(new KEdge(2, 1));
        adj[3].add(new KEdge(3, 4));

    }
    public void topoSort(ArrayList<KEdge> adj[],int V,int curr,boolean visited[],Stack<Integer> s)
    {
    
        visited[curr]=true;

        for(int i=0;i<adj[curr].size();i++)
        {
            KEdge e=adj[curr].get(i);
            int u=e.src;
            int v=e.dest;
            if(!visited[v])
            {
                topoSort(adj, V, v, visited, s);
            }
        }
        s.push(curr);

    }
    public void reverseGraph(ArrayList<KEdge> adj[],int V,int src)
    {
        for(int i=0;i<adj.length;i++)
        {
            for(int j=0;j<adj[i].size();j++)
            {
                KEdge e=adj[i].get(j);

                int s=e.src;
                int t=e.dest;

                s=s^t;
                t=t^s;
                s=s^t;

                adj[i].remove(e);
                adj[s].add(new KEdge(s, t));
            }
            
        }
    }
    public void dfs(ArrayList<KEdge> adj[],int V,int curr,boolean visited[])
    {
        visited[curr]=true;
        System.out.print(curr);
        for(int i=0;i<adj[curr].size();i++)
        {
            KEdge e=adj[curr].get(i);
            int src=e.src;
            int dest=e.dest;
            if(!visited[dest])
            {
                dfs(adj, V, dest, visited);
            }
        }

    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<KEdge> adj[]=new ArrayList[V];
        Kosaraju k=new Kosaraju();
        k.createGraph(adj,V);
        boolean visited[]=new boolean[V];
        Stack<Integer> s=new Stack<>();
        k.topoSort(adj,V,0,visited,s);
        ArrayList<KEdge> rev[]=adj;
        k.reverseGraph(rev,V,0);
        boolean revVisited[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            int val=s.pop();
            if(!revVisited[val])
            {
                k.dfs(rev,V,val,revVisited);
                System.out.println();
            }
        }

    }
}

class KEdge
{
    int src;
    int dest;
    public KEdge(int src,int dest)
    {
        this.src=src;
        this.dest=dest;
    }
}