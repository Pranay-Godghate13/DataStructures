import java.util.PriorityQueue;

public class DiagonalMatrixSort {

    public void createMatrix(int mat[][],int row,int column)
    {
        mat[0][0]=3;
        mat[0][1]=3;
        mat[0][2]=1;
        mat[0][3]=1;

        mat[1][0]=2;
        mat[1][1]=2;
        mat[1][2]=1;
        mat[1][3]=2;

        mat[2][0]=1;
        mat[2][1]=1;
        mat[2][2]=1;
        mat[2][3]=2;

    }
    public void sortMatrix(int mat[][],int r,int c)
    {
        int m=mat.length;
        int n=mat[0].length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=r,j=c;i<m && j<n;i++,j++)
        {
            pq.add(mat[i][j]);
        }

        while(!pq.isEmpty())
        {
            mat[r++][c++]=pq.remove();
        }
    }
    public void printMat(int mat[][],int row,int column)
    {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int row=3;          // constant
        int column=4;
        int mat[][]=new int[row][column];
        DiagonalMatrixSort dms=new DiagonalMatrixSort();
        dms.createMatrix(mat,row,column);
        
        for(int i=mat[0].length-1;i>=0;i--)
        {                                       // (col+row)*log(row+col)
            dms.sortMatrix(mat,0,i);
        }

        for(int i=0;i<mat.length;i++)
        {
            dms.sortMatrix(mat, i, 0);
        }

        dms.printMat(mat,row,column);
              
    }
}
