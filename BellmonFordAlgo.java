import java.util.ArrayList;

public class BellmonFordAlgo {
    public void createGraph(ArrayList<EW> adj[],int V)
    {
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }

        adj[0].add(new EW(0, 1, 2));
        adj[0].add(new EW(0, 2, 4));

        adj[1].add(new EW(1, 2, -4));

        adj[2].add(new EW(2, 3, 2));

        adj[3].add(new EW(3, 4, 4));

        adj[4].add(new EW(4, 1, -1));

    }
    public void bellmondFordAlgo(ArrayList<EW> adj[],int src,int V)
    {
        int dist[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(i!=src)
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<V-1;i++)
        {
            for(int j=0;j<V;j++)
            {
                for(int k=0;k<adj[j].size();k++)
                {
                    EW e=adj[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt<dist[v])
                    {
                        dist[v]=dist[u]+e.wt;
                    }
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<EW> adj[]=new ArrayList[V];
        BellmonFordAlgo bfa=new BellmonFordAlgo();
        bfa.createGraph(adj, V);
        bfa.bellmondFordAlgo(adj,0,V);
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
