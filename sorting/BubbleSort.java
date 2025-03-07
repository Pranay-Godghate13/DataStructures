package sorting;

public class BubbleSort {
    public static void swap(int arr[],int x,int y)
    {
        arr[x]=arr[x]^arr[y];
        arr[y]=arr[x]^arr[y];
        arr[x]=arr[x]^arr[y];
    }
    public static void bubbleSort(int arr[]) {
        // code here
        int n=arr.length;
        for(int i=n-1;i>=1;i--)
        {
            for(int j=0;j<=i-1;j++)
            {
                if(arr[j]>arr[j+1])
                swap(arr,j,j+1);
            }
        }
    }
}
