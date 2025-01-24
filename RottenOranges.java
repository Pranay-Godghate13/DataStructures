import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public void createGraph(int arr[][],int m,int n)
    {
        arr[0][0]=2;
        arr[0][1]=1;
        arr[0][2]=1;
        arr[1][0]=0;
        arr[1][1]=1;
        arr[1][2]=1;
        arr[2][0]=1;
        arr[2][1]=0;
        arr[2][2]=1;
    }
    public void display(int arr[][],int m,int n)
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public int timeTaken(int arr[][],Queue<Location> q,int time,int m,int n)
    {
        while(!q.isEmpty())
        {
            Location removed=q.remove();
            if(removed==null)
            {
                time+=1;
                if(!q.isEmpty())
                q.add(null);
            }
            
            else
            {
                int row=removed.row;
                int column=removed.column;
                if(row+1<m && arr[row+1][column]==1)
                {
                    arr[row+1][column]=2;
                    q.add(new Location(row+1, column));
                }
                if(row-1>=0 && arr[row-1][column]==1)
                {
                    arr[row-1][column]=2;
                    q.add(new Location(row-1, column));
                }
                if(column+1<n && arr[row][column+1]==1)
                {
                    arr[row][column+1]=2;
                    q.add(new Location(row, column+1));
                }
                if(column-1>=0 && arr[row][column-1]==1)
                {
                    arr[row][column-1]=2;
                    q.add(new Location(row, column-1));
                }
            }



        }
        return time;
    }
    public static void main(String[] args) {
        int m=3;
        int n=3;
        int arr[][]=new int[m][n];
        RottenOranges ro=new RottenOranges();
        ro.createGraph(arr,m,n);
        // ro.display(arr,m,n);
        Queue<Location> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==2)
                q.add(new Location(i,j));
            }
        }
        q.add(null);
        int time=0;
        int ans=ro.timeTaken(arr,q,time,m,n);
        ans-=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1)
                ans=-1;
            }
        }
        System.out.println(ans);
    }
}
class Location
{
    int row;
    int column;
    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
}
