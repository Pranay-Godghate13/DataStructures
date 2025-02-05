class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjoinSet alice=new DisjoinSet(n);
        DisjoinSet bob=new DisjoinSet(n);
        int requiredEdge=0;
        for(int edge[]:edges)
        {
            if(edge[0]==3)
            {
                int a=alice.unionBySize(edge[1],edge[2]);
                int b=bob.unionBySize(edge[1],edge[2]);
                if(a!=0 && b!=0)
                requiredEdge++;
            }
        }
        for(int edge[]:edges)
        {
            if(edge[0]==1)
            {
                int a=alice.unionBySize(edge[1],edge[2]);
                // bob.unionBySize(edge[1],edge[2]);
                if(a!=0)
                requiredEdge++;
            }
            if(edge[0]==2)
            {
                // alice.unionBySize(edge[1],edge[2]);
                int b=bob.unionBySize(edge[1],edge[2]);
                if(b!=0)
                requiredEdge++;
            }
        }
        if(alice.component==1 && bob.component==1)
        return edges.length-requiredEdge;
        else
        return -1;        
    }
}
class DisjoinSet
{
    int parents[];
    int size[];
    int component;
    DisjoinSet(int nodes)
    {
        this.parents=new int[nodes+1];
        this.size=new int[nodes+1];
        this.component=nodes;

        for(int i=0;i<nodes+1;i++)
        {
            parents[i]=i;
            size[i]=1;
        }
    }

    public int findParent(int node)
    {
        if(node==parents[node])
        return node;
        parents[node]=findParent(parents[node]);
        return parents[node];
    }

    public int unionBySize(int node1,int node2)
    {
        int rootParent1=findParent(node1);
        int rootParent2=findParent(node2);
        
        if(rootParent1==rootParent2)
        return 0;
        component--;
        if(size[rootParent1]<size[rootParent2])
        {
            parents[rootParent1]=parents[rootParent2];
            size[node2]++;
        }
        else
        {
            parents[rootParent2]=parents[rootParent1];
            size[node1]++;
        }
        return 1;

    }



}