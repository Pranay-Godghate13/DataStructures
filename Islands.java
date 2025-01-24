


public class Islands {
    public void createGraph(int arr[][])
    {
        arr[0][0]=1;
        arr[0][1]=1;
        arr[0][2]=0;
        arr[0][3]=0;
        arr[0][4]=0;
        arr[1][0]=1;
        arr[1][1]=1;
        arr[1][2]=0;
        arr[1][3]=0;
        arr[1][4]=0;
        arr[2][0]=0;
        arr[2][1]=0;
        arr[2][2]=1;
        arr[2][3]=0;
        arr[2][4]=0;
        arr[3][0]=0;
        arr[3][1]=0;
        arr[3][2]=0;
        arr[3][3]=1;
        arr[3][4]=1;


    }
    public void countIsland(int arr[][],boolean visited[][],int i,int j,int m,int n)
        {
            if(visited[i][j])
            return;
            else
            {
                visited[i][j]=true;
                if(i+1<m && visited[i+1][j]==false && arr[i+1][j]==1)
                {
                    countIsland(arr, visited, i+1, j, m, n);
                }
                if(i-1>=0 && visited[i-1][j]==false && arr[i-1][j]==1)
                {
                    countIsland(arr, visited, i-1, j, m, n);
                }
                if(j+1<n && visited[i][j+1]==false && arr[i][j+1]==1)
                {
                    countIsland(arr, visited, i, j+1, m, n);
                }
                if(j-1>=0 && visited[i][j-1]==false && arr[i][j-1]==1)
                {
                    countIsland(arr, visited, i, j-1, m, n);
                }

            }
            

        }
    
    public static void main(String[] args) {
        int m=4;
        int n=5;
        int arr[][]=new int[m][n];
        Islands is=new Islands();
        int ans=0;
        is.createGraph(arr);
        boolean visited[][]=new boolean[m][n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==false && arr[i][j]==1)
                {
                    ans+=1;
                   
                    is.countIsland(arr,visited,i,j,m,n);
                }
            }
        }
        System.out.println(ans);
    }
} 

class Location1
{
    int row;
    int column;
    public Location1(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
}
