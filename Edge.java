public class Edge
{
    int source;
    int destination;
    int amount;
    public Edge(int source,int destination,int amount)
    {
        this.source=source;
        this.destination=destination;
        this.amount=amount;
    }
    @Override
    public String toString() {
        return "Edge [source=" + source + ", destination=" + destination + ", amount=" + amount + "]";
    }
    
}