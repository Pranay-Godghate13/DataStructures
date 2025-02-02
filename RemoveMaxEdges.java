import java.util.ArrayList;
import java.util.PriorityQueue;

public class RemoveMaxEdges {
    //EDGES TYPE
    //Type-1 by Alice
    //Type-2 by bob
    //Type-3 by both alice and bob

    //Return max number of edges to be removed or else return -1
    public void createGraph(ArrayList<RMEEdge> adj[],int V,int edges[][])
    {
        for(int i=0;i<=V;i++)
        {
            adj[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int type=edges[i][0];
            int src=edges[i][1];
            int dest=edges[i][2];

            adj[src].add(new RMEEdge(type, src, dest));
            adj[dest].add(new RMEEdge(type, dest, src));
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        ArrayList<RMEEdge> adj[]=new ArrayList[n+1];
        createGraph(adj,n,edges);
        // for(int i=1;i<=n;i++)
        // {
        //     for(int j=0;j<adj[i].size();j++)
        //     {
        //         System.out.println(adj[i].get(j).type+" "+adj[i].get(j).src+" "+adj[i].get(j).dest);
        //     }
        //     System.out.println();
        // }
        ArrayList<Integer> adj1=new ArrayList<>();
        PriorityQueue<PEdge> pq=new PriorityQueue<>();
        pq.add(new PEdge(3, 1));
        boolean visited[]=new boolean[n+1];
        while(!pq.isEmpty())
        {
            PEdge removed=pq.remove();
            if(visited[removed.node]==false)
            {
                visited[removed.node]=true;
                adj1.add(removed.type);
                //System.out.println(adj1);
                for(int i=0;i<adj[removed.node].size();i++)
                {
                    if(visited[adj[removed.node].get(i).dest]==false)
                    {
                        RMEEdge e=adj[removed.node].get(i);

                        pq.add(new PEdge(e.type, e.dest));
                    }

                }
            }
            
        }
        return edges.length-adj1.size();
        // b/w 2 nodes type 3,2,1-->3
        // b/w 2 nodes type 3-->3
        // b/w 2 node type 1
        
        // return 1;
    }
    public static void main(String args[])
    {
        int V=4;
        RemoveMaxEdges rme=new RemoveMaxEdges();
        int edge[][]={{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        int result=rme.maxNumEdgesToRemove(V,edge);
        System.out.println(result);

    }
}
class RMEEdge
{
    int type;
    int src;
    int dest;
    public RMEEdge(int type, int src, int dest) {
        this.type = type;
        this.src = src;
        this.dest = dest;
    }
    
     
}
class PEdge implements Comparable<PEdge>
{
    int type;
    int node;
    public PEdge(int type, int node) {
        this.type = type;
        this.node = node;
    }
    @Override
    public int compareTo(PEdge o) {
        return o.type-this.type;
    
}
}
