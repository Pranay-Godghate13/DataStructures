public class MST {
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
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0,-1));
        int visited[]=new int[V];
        int sum=0;
        while(!pq.isEmpty())
        {
            int edgeWeight=pq.peek().edgeWeight;
            int node=pq.peek().node;
            int par=pq.peek().par;
            pq.remove();
            
            if(visited[node]==1)
            continue;
            
            visited[node]=1;
            sum+=edgeWeight;
            
            for(int i=0;i<adj.get(node).size();i++)
            {
                int a[]=adj.get(node).get(i);
                int destNode=a[0];
                int weight=a[1];
                
                if(visited[destNode]==0)
                {
                    pq.add(new Pair(weight,destNode,node));
                }
            }
        }
        return sum;
    }
}
class Pair implements Comparable<Pair>
{
    int edgeWeight;
    int node;
    int par;
    
    Pair(int edgeWeight,int node,int par)
    {
        this.edgeWeight=edgeWeight;
        this.node=node;
        this.par=par;
    }
    @Override
    public int compareTo(Pair p)
    {
        if(p.edgeWeight<this.edgeWeight)
        return 1;
        else
        return -1;
    }
}
}
