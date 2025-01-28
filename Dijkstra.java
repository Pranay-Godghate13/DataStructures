import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    public void createGraph(ArrayList<EW> adj[],int V)
    {
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }

        adj[0].add(new EW(0, 1, 2));
        adj[0].add(new EW(0, 2, 4));

        adj[1].add(new EW(1, 2, 1));
        adj[1].add(new EW(1, 3, 7));

        adj[2].add(new EW(2, 4, 3));

        adj[3].add(new EW(3, 5, 1));

        adj[4].add(new EW(4, 3, 2));
        adj[4].add(new EW(4, 5, 5));

        adj[5].add(new EW(5, 5, 0));


    }
    class Pair implements Comparable<Pair>
    {
        int node;
        int dist;

        Pair(int n,int d)
        {
            this.node=n;
            this.dist=d;
        }

        @Override
        public int compareTo(Pair p) {
            return this.dist-p.dist;
        }
        
    }

    public void dijkstra(ArrayList<EW> adj[],int V,int src)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int shortDist[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(i!=src)
            {
                shortDist[i]=Integer.MAX_VALUE;
            }
        }

        boolean visited[]=new boolean[V];
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty())
        {
            Pair removed=pq.remove();
            if(!visited[removed.node])
            {
                visited[removed.node]=true;
                for(int i=0;i<adj[removed.node].size();i++)
                {
                    EW e=adj[removed.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    if(shortDist[u]+e.wt<shortDist[v])
                    {
                        shortDist[v]=shortDist[u]+e.wt;
                        pq.add(new Pair(v, shortDist[v]));
                    }
                }
            }
            
        }

        for(int i=0;i<V;i++)
        {
            System.out.print(shortDist[i]+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<EW> adj[]=new ArrayList[V];
        Dijkstra d=new Dijkstra();
        d.createGraph(adj,V);

        d.dijkstra(adj,V,0);

    }
}

class EW
{
    int src;
    int dest;
    int wt;
    
    public EW(int src,int dest,int wt)
    {
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }

}