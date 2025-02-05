import java.util.ArrayList;

public class TarjanAlgo {
    public void createGraph(ArrayList<PairTA> adj[],int V)
    {
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }

        // adj[0].add(new PairTA(0, 1));
        // adj[0].add(new PairTA(0, 2));
        // adj[0].add(new PairTA(0, 3));

        // adj[1].add(new PairTA(1, 0));
        // adj[1].add(new PairTA(1, 2));

        // adj[2].add(new PairTA(2, 1));
        // adj[2].add(new PairTA(2, 0));

        // adj[3].add(new PairTA(3, 0));
        // adj[3].add(new PairTA(3, 4));
        // adj[3].add(new PairTA(3, 5));

        // adj[4].add(new PairTA(4, 3));
        // adj[4].add(new PairTA(4, 5));

        // adj[5].add(new PairTA(5, 3));
        // adj[5].add(new PairTA(5, 4));


        adj[0].add(new PairTA(0, 1));
        adj[0].add(new PairTA(0, 2));
        adj[0].add(new PairTA(0, 3));

        adj[1].add(new PairTA(1, 0));
        adj[1].add(new PairTA(1, 2));

        adj[2].add(new PairTA(2, 0));
        adj[2].add(new PairTA(2, 1));

        adj[3].add(new PairTA(3, 0));
        adj[3].add(new PairTA(3, 4));

        adj[4].add(new PairTA(4, 3));

    }
    public void targanDFS(int dt[],int lowT[],int curr,int par,ArrayList<PairTA> adj[],boolean visited[],int time)
    {
        visited[curr]=true;
        dt[curr]=lowT[curr]=++time;
        
        for(int i=0;i<adj[curr].size();i++)
        {
            PairTA e=adj[curr].get(i);
            if(e.dest==par)
            continue;
            if(!visited[e.dest])
            {
                targanDFS(dt, lowT, e.dest, curr, adj, visited,time);
                lowT[curr]=Math.min(lowT[curr],lowT[e.dest]);
                if(dt[curr]<lowT[e.dest])
                System.out.println(curr+"---->"+e.dest);
            }
            else
                lowT[curr]=Math.min(dt[e.dest],lowT[curr]);
            



        }
        // System.out.println("Hello");


    }
    public static void main(String[] args) {
        int V=6;
        TarjanAlgo ta=new TarjanAlgo();
        ArrayList<PairTA> adj[]=new ArrayList[V];
        ta.createGraph(adj,V);
        int dt[]=new int[V];
        int lowT[]=new int[V];
        boolean visited[]=new boolean[V];
        int time=0;
        int par=-1;
        int curr=0;
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                ta.targanDFS(dt,lowT,curr,par,adj,visited,time);
            }
        }
        
    }
}
class PairTA
{
    int src;
    int dest;
    PairTA(int src,int dest)
    {
        this.src=src;
        this.dest=dest;
    }
}
