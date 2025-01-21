import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void createGraph(int v,ArrayList<Edge> adj[])
    {
        for(int i=0;i<v;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[0].add(new Edge(0, 1));
        adj[0].add(new Edge(0, 2));
        adj[1].add(new Edge(1, 3));
        adj[2].add(new Edge(2, 4));
        adj[3].add(new Edge(3, 1));
        adj[3].add(new Edge(3, 4));
        adj[3].add(new Edge(3, 5));
        adj[4].add(new Edge(4, 2));
        adj[4].add(new Edge(4, 3));
        adj[4].add(new Edge(4, 5));
        adj[5].add(new Edge(5, 3));
        adj[5].add(new Edge(5, 4));
        adj[5].add(new Edge(5, 6));
        adj[6].add(new Edge(6, 5));
    }
    public void bfs(int v,ArrayList<Edge> adj[],Queue<Integer> q,boolean visited[])
    {
        
        while(!q.isEmpty())
        {
            int removed=q.remove();
            if(!visited[removed])
            {
                System.out.print(removed);
                visited[removed]=true;
            
            for(int i=0;i<adj[removed].size();i++)
            {
                if(!visited[adj[removed].get(i).destination])
                {
                    q.add(adj[removed].get(i).destination);
                }
            }
        }
        }

        

    }
    public static void main(String args[])
    {
        int v=7;
        ArrayList<Edge> adj[]=new ArrayList[v];
        BFS obj=new BFS();
        obj.createGraph(v, adj);
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(visited[i]==false)
            obj.bfs(v, adj, q, visited);
        }
        
        // for(int i=0;i<v;i++)
        // {
        //     System.out.println(i+" | "+adj[i]);
        // }
    }
}

class Edge
{
    int source;
    int destination;

    Edge(int source,int destination)
    {
        this.source=source;
        this.destination=destination;
    }
    @Override
    public String toString() {
        return "[" + source + "," + destination +"]";
    }
    
}