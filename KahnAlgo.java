import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgo {
    static void bfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,int N)
    {
        Queue<Integer> q=new LinkedList<>(); //O(N)
        int incEdge[]=new int[N];//O(N)
        for(int i=0;i<N;i++)//O(N+E)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                incEdge[adj.get(i).get(j)]++;
            }
        }

        for(int i=0;i<N;i++)//O(N)
        {
            if(incEdge[i]==0)
            q.add(i);
        }
        
        while(!q.isEmpty())//O(N)
        {
            int removed=q.peek();
            ans.add(removed);
            q.remove();
            
            for(int i=0;i<adj.get(removed).size();i++) //O(L)
            {
                incEdge[adj.get(removed).get(i)]--;
                if(incEdge[adj.get(removed).get(i)]==0)
                q.add(adj.get(removed).get(i));
            }
        }
        
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        
        int N=adj.size();
        ArrayList<Integer> ans=new ArrayList<>();
        bfs(adj,ans,N);
        return ans;
    }
}
