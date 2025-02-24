public class KhursalAlgo {
    //{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int findParent(int par[],int x)
    {
        if(par[x]==x)
        return x;
        else
        return par[x]=findParent(par,par[x]);
    }
    static void findUnion(int rank[],int par[],int u,int v)
    {
        int pu=findParent(par,u);
        int pv=findParent(par,v);
        if(rank[pu]==rank[pv])
        {
            par[pv]=par[pu];
            rank[pu]++;
        }
        else if(rank[pu]<rank[pv])
        {
            par[pu]=par[pv];
        }
        else
        {
            par[pv]=par[pu];
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        //Sort the ArrayList as per weight wise.
        ArrayList<Pair> list=new ArrayList<>();
        //DSU will be applied.
        for(int i=0;i<adj.size();i++)
        {
            List<int[]> a=adj.get(i);
            for(int j=0;j<a.size();j++)
            {
                int arr[]=a.get(j);
                int dest=arr[0];
                int edgeWeight=arr[1];
                list.add(new Pair(edgeWeight,i,dest));
                // list.add(new Pair(edgeWeight,dest,i));
            }
        }
        Collections.sort(list);
        int sum=0;
        int rank[]=new int[V];
        int par[]=new int[V];
        for(int i=0;i<V;i++)
        {
            rank[i]=0;
            par[i]=i;
        }
        for(int i=0;i<list.size();i++)
        {
            int wt=list.get(i).wt;
            int u=list.get(i).src;
            int v=list.get(i).dest;
            
            if(findParent(par,u)!=findParent(par,v))
            {
                sum+=wt;
                findUnion(rank,par,u,v);
            }
        }
        return sum;
    }
}
class Pair implements Comparable<Pair>
{
    int wt;
    int src;
    int dest;
    Pair(int wt,int src,int dest)
    {
        this.wt=wt;
        this.src=src;
        this.dest=dest;
    }
    @Override
    public int compareTo(Pair p)
    {
        return this.wt-p.wt;
    }
}
}
