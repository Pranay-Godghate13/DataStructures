import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prism {
    public void createGraph(ArrayList<MSTEdge> adj[],int V)
    {
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }

        adj[0].add(new MSTEdge(0, 1, 10));
        adj[0].add(new MSTEdge(0, 2, 15));
        adj[0].add(new MSTEdge(0, 3, 30));

        adj[1].add(new MSTEdge(1, 0, 10));
        adj[1].add(new MSTEdge(1, 3, 40));

        adj[2].add(new MSTEdge(2, 0, 15));
        adj[2].add(new MSTEdge(2, 3, 50));

        adj[3].add(new MSTEdge(3, 0, 30));
        adj[3].add(new MSTEdge(3, 1, 40));
        adj[3].add(new MSTEdge(3, 2 ,50));
    }
    public void mstAlgo(ArrayList<MSTEdge> adj[],int src,int V)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));

        boolean visited[]=new boolean[V];
        int cost=0;

        while(!pq.isEmpty())
        {
            Pair removed=pq.remove();
            if(!visited[removed.node])
            {
                visited[removed.node]=true;
                cost+=removed.price;
                for(int i=0;i<adj[removed.node].size();i++)
                {
                    if(!visited[adj[removed.node].get(i).dest])
                    pq.add(new Pair(adj[removed.node].get(i).dest, adj[removed.node].get(i).price));
                }
            }
        }
        System.out.println(cost);

    }
    public static void main(String[] args) {
        Prism p=new Prism();
        int V=4;
        ArrayList<MSTEdge> adj[]=new ArrayList[V];
        p.createGraph(adj,V);
        p.mstAlgo(adj,0,V);



    }
}
class Pair implements Comparable<Pair>
{
    int node;
    int price;
    public Pair(int node,int price)
    {
        this.node=node;
        this.price=price;
    }
    @Override
    public int compareTo(Pair o) {
        return this.price-o.price;
    }

}
class MSTEdge
{
    int src;
    int dest;
    int price;
    public MSTEdge(int src,int dest,int price)
    {
        this.src=src;
        this.dest=dest;
        this.price=price;
    }
}
