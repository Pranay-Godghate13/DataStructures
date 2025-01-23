import java.util.ArrayList;

public class AllPaths {
    public void createGraph(int V, ArrayList<Edge1> adj[])
    {
        for(int i=0;i<V;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[0].add(new Edge1(0, 1));
        adj[0].add(new Edge1(0, 2));
        adj[1].add(new Edge1(1, 0));
        adj[1].add(new Edge1(1, 3));
        adj[2].add(new Edge1(2, 0));
        adj[2].add(new Edge1(2, 4));
        adj[3].add(new Edge1(3, 1));
        adj[3].add(new Edge1(3, 4));
        adj[3].add(new Edge1(3, 5));
        adj[4].add(new Edge1(4, 2));
        adj[4].add(new Edge1(4, 3));
        adj[4].add(new Edge1(4, 5));
        adj[5].add(new Edge1(5, 3));
        adj[5].add(new Edge1(5, 4));
        adj[5].add(new Edge1(5, 6));
        adj[6].add(new Edge1(6, 5));
    }
    public void printPaths(int curr,int tgt,String path, ArrayList<Edge1> adj1[], boolean visited[],int V)
    {
        if(curr==tgt)
        {
            path+=curr;
            System.out.println(path);
            return;
        }
        
        else
        {
            
            
            int length=adj1[curr].size();
            for(int i=0;i<length;i++)
            {
                Edge1 e=adj1[curr].get(i);
                if(visited[e.target]==false)
                {
                    
                    visited[curr]=true;
                    printPaths(e.target, tgt,path+curr, adj1, visited, V);
                    visited[curr]=false;
                }
                
            }

        }
        
    }
    public static void main(String[] args) {
        int V=7;
        int src=0;
        int tgt=5;
        ArrayList<Edge1> adj1[]=new ArrayList[V];
        AllPaths obj=new AllPaths();
        obj.createGraph(V,adj1);
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }
        obj.printPaths(0, 5,"", adj1, visited, V);
    }
}

class Edge1
{
    int source;
    int target;
    public Edge1(int source, int target) {
        this.source = source;
        this.target = target;
    }
    @Override
    public String toString() {
        return "Edge1 [source=" + source + ", target=" + target + "]";
    }
    
}