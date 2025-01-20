import java.util.ArrayList;
import java.util.List;

public class Adjacency {
    public void createGraph(int v,ArrayList<Edge> adj[])
    {
        for(int i=0;i<v;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[0].add(new Edge(0, 2));
        adj[1].add(new Edge(1, 2));
        adj[1].add(new Edge(1, 3));
        adj[2].add(new Edge(2, 0));
        adj[2].add(new Edge(2, 1));
        adj[2].add(new Edge(2, 3));
        adj[3].add(new Edge(3, 1));
        adj[3].add(new Edge(3, 2));
    }
    public static void main(String args[])
    {
        int v=4;
        ArrayList<Edge> adj[]=new ArrayList[v];
        Adjacency obj=new Adjacency();
        obj.createGraph(v, adj);
        for(int i=0;i<v;i++)
        {
            System.out.println(i+" . "+adj[i]);
        }
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