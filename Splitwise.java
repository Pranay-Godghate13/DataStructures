import java.util.ArrayList;

public class Splitwise{
    //Edge edge;
    public void createGraph(int v,ArrayList<Transaction> adj[])
    {
        for(int i=0;i<v;i++)
        {
            adj[i]=new ArrayList<>();
        }
        adj[0].add(new Transaction(0, 1,50));
        adj[1].add(new Transaction(1, 0,100));
        
    }
    public void dfs(ArrayList<Transaction> adj[],int curr,boolean visited[])
    {
        if(visited[curr]==true)
        return;
        else
        {
            visited[curr]=true;
            int length=adj[curr].size();
            for(int i=0;i<length;i++)
            {
                Transaction e=adj[curr].get(i);
                if(visited[e.target]==false)
                {
                    System.out.println(e);
                    dfs(adj, e.target, visited);
                }
            }
            visited[curr]=false;
            
        }
    }
    public static void main(String args[])
    {
        int v=2;
        ArrayList<Transaction> adj[]=new ArrayList[v];
        Splitwise obj=new Splitwise();
        obj.createGraph(v, adj);
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
            visited[i]=false;
        }
        for(int i=0;i<v;i++)
        {
            if(visited[i]==false)
            obj.dfs(adj,i,visited);
        }
    }
}

class Transaction
{
    int source;
    int target;
    int amount;
    public Transaction(int source, int target, int amount) {
        this.source = source;
        this.target = target;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Transaction " + source + "->" + target + ", amount=" + amount ;
    }

    
}


