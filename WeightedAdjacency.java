import java.util.ArrayList;

public class WeightedAdjacency {
    
    public static void createGraph(int v, ArrayList<Edge> adj[])
    {
        for(int i=0;i<4;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[0].add(new Edge(0, 2, 2));
        adj[1].add(new Edge(1, 3, 0));
        adj[1].add(new Edge(1, 2, 10));
        adj[2].add(new Edge(2, 0, 2));
        adj[2].add(new Edge(2, 3, -1));
        adj[2].add(new Edge(2, 1, 10));
        adj[3].add(new Edge(3, 2, -1));
        adj[3].add(new Edge(3, 1, 0));

    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> adj[]=new ArrayList[v];
        createGraph(v, adj);

        for(int i=0;i<v;i++)
        {
            System.out.println(i+" | "+adj[i]);
        }
        
    }
    
}

class Edge
{
    int source;
    int destination;
    int weight;

    Edge(int source,int destination,int weight)
    {
        this.source=source;
        this.destination=destination;
        this.weight=weight;
    }
    @Override
    public String toString() {
        return "[" + source + "," + destination +","+weight+"]";
    }
    
}