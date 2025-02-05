import java.util.ArrayList;

public class Articulate {
    public void createGraph(int V,ArrayList<AEdge> adj[])
    {
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }

        adj[0].add(new AEdge(0, 1));
        adj[0].add(new AEdge(0, 2));
        adj[0].add(new AEdge(0, 3));

        adj[1].add(new AEdge(1, 0));
        adj[1].add(new AEdge(1, 2));

        adj[2].add(new AEdge(2, 0));
        adj[2].add(new AEdge(2, 1));

        adj[3].add(new AEdge(3, 0));
        adj[3].add(new AEdge(3, 4));

        adj[4].add(new AEdge(4, 3));

    }
    public void dfs(ArrayList<AEdge> adj[],int df[],int low[],int curr,int time,int par,boolean visited[],int child)
        {
            visited[curr]=true;
            df[curr]=low[curr]=++time;
    
            for(int i=0;i<adj[curr].size();i++)
            {
                AEdge e=adj[curr].get(i);
                if(visited[e.dest])
                {
                    low[curr]=Math.min(low[curr],df[e.dest]);
                }
                else if(!visited[e.dest])
                {
                    dfs(adj, df, low, e.dest, time, curr, visited,child);
                low[curr]=Math.min(low[curr],low[e.dest]);
                if(df[curr]<=low[e.dest] && par!=-1)
                {
                    System.out.println("Articulated point :"+curr);

                }
                child++;
            }

        }
        if(par==-1 && child>1)
        System.out.println("Articulated point :"+curr);

    }
    public void checkArticulate(ArrayList<AEdge> adj[],int V)
    {
        int df[]=new int[V];
        int low[]=new int[V];
        int curr=0;
        int par=-1;
        int time=0;
        int child=0;
        boolean visited[]=new boolean[V];
        dfs(adj,df,low,curr,time,par,visited,child);
    }
    public static void main(String[] args) {
        int V=5;
        Articulate a=new Articulate();
        ArrayList<AEdge> adj[]=new ArrayList[V];
        a.createGraph(V,adj);
        a.checkArticulate(adj,V);

    }
}

class AEdge
{
    int src;
    int dest;
    AEdge(int src,int dest)
    {
        this.src=src;
        this.dest=dest;

    }
}