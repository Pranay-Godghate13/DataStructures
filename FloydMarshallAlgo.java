public class FloydMarshallAlgo {
    public void createGraph(int arr[][],int row,int column)
    {
        arr[0][0]=0;
        arr[0][1]=2;
        arr[0][2]=Integer.MAX_VALUE;
        arr[0][3]=Integer.MAX_VALUE;
        
        arr[1][0]=1;
        arr[1][1]=0;
        arr[1][2]=3;
        arr[1][3]=Integer.MAX_VALUE;

        arr[2][0]=Integer.MAX_VALUE;
        arr[2][1]=Integer.MAX_VALUE;
        arr[2][2]=0;
        arr[2][3]=Integer.MAX_VALUE;

        arr[3][0]=3;
        arr[3][1]=5;
        arr[3][2]=4;
        arr[3][3]=0;
    }
    public void floydAlgo(int arr[][],int row,int column)
    {
        for(int k=0;k<row;k++)
        {
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<column;j++)
                {
                    arr[i][j]=Math.min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }
        
    }
    public void print(int arr[][],int row,int column)
    {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int row=4;
        int column=4;
        int arr[][]=new int[row][column];
        FloydMarshallAlgo fma=new FloydMarshallAlgo();
        fma.createGraph(arr,row,column);
        fma.floydAlgo(arr,row,column);
        fma.print(arr,row,column);
    }
}
