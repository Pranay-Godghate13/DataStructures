import java.util.ArrayList;

public class CourseSchedule {
    public void createGraph(ArrayList<CSEdge> adj[],int v)
    {
        for(int i=0;i<v;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[0].add(new CSEdge(1, 0));
        //adj[1].add(new CSEdge(1, 0));
    }
    public boolean findCycle(ArrayList<CSEdge> adj[],boolean visited[],boolean recStack[],int curr)
    {
        visited[curr]=true;
        recStack[curr]=true;
        for(int i=0;i<adj[curr].size();i++)
        {
            CSEdge e=adj[curr].get(i);
            if(recStack[e.dest])
            return true;
            if(!visited[e.dest])
            {
                if(findCycle(adj, visited, recStack, e.dest))
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        int v=2;
        ArrayList<CSEdge> adj[]=new ArrayList[v];
        CourseSchedule cs=new CourseSchedule();
        cs.createGraph(adj,v);
        boolean visited[]=new boolean[v];
        boolean recStack[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(!visited[i])
            {
                if(!cs.findCycle(adj,visited,recStack,i))
                {
                    System.out.println("True");
                    break;
                } 
            }
            
        }
    }
}
class CSEdge
{
    int src;
    int dest;
    public CSEdge(int dest, int src) {
        this.src = src;
        this.dest = dest;
    }

}

