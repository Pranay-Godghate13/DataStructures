//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        
        if(start==end)
        return 0;
        Queue<Pair> q=new LinkedList<>();
        int visited[]=new int[100000];
        for(int i=0;i<100000;i++)
        {
            visited[i]=Integer.MAX_VALUE;
            
        }
        visited[start]=0;
        int mod=100000;
        q.add(new Pair(start,0));
        while(!q.isEmpty())
        {
            int node=q.peek().node;
            int count=q.peek().count;
            q.remove();
            
            for(int i=0;i<arr.length;i++)
            {
                int element=(node*arr[i])%mod;
                if(count+1<visited[element])
                {
                    visited[element]=count+1;
                    if(element==end)
                    return count+1;
                    q.add(new Pair(element,count+1));
                }
            }
        }
        return -1;
    }
}
class Pair
{
    int node;
    int count;
    Pair(int node,int count)
    {
        this.node=node;
        this.count=count;
    }
}