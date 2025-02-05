public class DisjoinSet {
    int parents[];
    int rank[];
    int components;
    int size[];

    DisjoinSet(int nodes)
    {
        this.parents=new int[nodes];
        this.rank=new int[nodes];
        this.size=new int[nodes];
        this.components=nodes;

        for(int i=0;i<this.components;i++)
        {
            parents[i]=i;
            rank[i]=0;
            size[i]=1;
        }
    }

    public int findParentNode(int u)
    {
        if(u==parents[u])
        return u;
        parents[u]=findParentNode(parents[u]);
        return parents[u];
    }
    public void unionByRank(int node1,int node2)
    {
        int rootParent1=findParentNode(node1);
        int rootParent2=findParentNode(node2);
        if(rootParent1==rootParent2)
        {
            return;
        }
        components--;
        if(rank[rootParent1]<rank[rootParent2])
        {
            parents[rootParent1]=rootParent2;
        }
        else if(rank[rootParent2]<rank[rootParent1])
        {
            parents[rootParent2]=rootParent1;
        }
        else
        {
            rank[rootParent1]++;
            parents[rootParent2]=rootParent1;
        }
    }

    public void unionBySize(int node1,int node2)
    {
        int rootParent1=findParentNode(node1);
        int rootParent2=findParentNode(node2);
        if(rootParent1==rootParent2)
        {
            return;
        }
        components--;
        if(size[rootParent1]<size[rootParent2])
        {
            parents[rootParent1]=rootParent2;
            size[rootParent1]+=size[rootParent2];
        }
        else
        {
            parents[rootParent2]=rootParent1;
            size[rootParent2]+=size[rootParent1];
        }
        
    }
    public static void main(String[] args) {
        // DisjoinSet ds=new DisjoinSet(4);
        // System.out.println("Number of components->"+ds.components);
        // System.out.println(ds.findParentNode(0)==ds.findParentNode(3));
        // ds.unionByRank(0, 3);
        // System.out.println("Number of components->"+ds.components);
        // System.out.println(ds.findParentNode(0)==ds.findParentNode(3));

        DisjoinSet ds=new DisjoinSet(4);
        System.out.println("Number of components->"+ds.components);
        System.out.println(ds.findParentNode(0)==ds.findParentNode(3));
        ds.unionBySize(0, 3);
        System.out.println("Number of components->"+ds.components);
        System.out.println(ds.findParentNode(0)==ds.findParentNode(3));
    }
}
