public class CheapestFlight {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            ArrayList<iPair> adj[]=new ArrayList[n];
            for(int i=0;i<n;i++)
            {
                adj[i]=new ArrayList<>();
            }
            for(int i=0;i<flights.length;i++)
            {
                adj[flights[i][0]].add(new iPair(flights[i][1],flights[i][2]));
            }
            Queue<Pair> q=new LinkedList<>();
            int totalFare[]=new int[n];
            for(int i=0;i<n;i++)
            {
                if(i==src)
                totalFare[i]=0;
                else
                totalFare[i]=Integer.MAX_VALUE;
            }
    
            q.add(new Pair(0,src,0));
            while(!q.isEmpty())
            {
                int currStops=q.peek().stops;
                int currNode=q.peek().node;
                int currCost=q.peek().cost;
                q.remove();
                if(currStops>k)
                continue;
                for(int i=0;i<adj[currNode].size();i++)
                {
                    int nextDest=adj[currNode].get(i).destNode;
                    int destPrice=adj[currNode].get(i).price;
    
                    if(currCost+destPrice<totalFare[nextDest] && currStops<=k)
                    {
                        totalFare[nextDest]=currCost+destPrice;
                        q.add(new Pair(currStops+1,nextDest,currCost+destPrice));
                    }
                }
    
            }
            if(totalFare[dst]==Integer.MAX_VALUE)
            return -1;
            else
            return totalFare[dst];
    
        }
    }
    class iPair
    {
        
        int destNode;
        int price;
        iPair(int destNode,int price)
        {
            
            this.destNode=destNode;
            this.price=price;
        }
    }
    class Pair
    {
        int stops;
        int node;
        int cost;
        Pair(int stops,int node,int cost)
        {
            this.stops=stops;
            this.node=node;
            this.cost=cost;
        }
    }
}
