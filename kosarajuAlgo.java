public class kosarajuAlgo {
    //{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to find number of strongly connected components in the graph.
    public void topoSort(ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int curr,boolean visited[])
    {
        visited[curr]=true;
        for(int i=0;i<adj.get(curr).size();i++)
        {
            int dest=adj.get(curr).get(i);
            if(!visited[dest])
            topoSort(adj,st,dest,visited);
        }
        st.push(curr);
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int curr)
    {
        visited[curr]=true;
        for(int i=0;i<adj.get(curr).size();i++)
        {
            int dest=adj.get(curr).get(i);
            if(!visited[dest])
            dfs(adj,visited,dest);
        }
    }
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        int n=adj.size();
        Stack<Integer> st=new Stack<Integer>();
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            topoSort(adj,st,i,visited);
        }
        ArrayList<ArrayList<Integer>> cdj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            cdj.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                cdj.get(adj.get(i).get(j)).add(i);
            }
        }
        for(int i=0;i<n;i++)
        {
            visited[i]=false;
        }
        int count=0;
        while(!st.isEmpty())
        {
            int elem=st.peek();
            if(!visited[elem])
            {
                ++count;
                dfs(cdj,visited,elem);
                
            }
            
            st.pop();
        }
        return count;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            System.out.println(obj.kosaraju(adj));

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends
}
