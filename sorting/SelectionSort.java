package sorting;

public class SelectionSort {
    void swap(int arr[],int min,int j)
    {
        arr[min]=arr[min]^arr[j];
        arr[j]=arr[min]^arr[j];
        arr[min]=arr[min]^arr[j];
    }
    void selectionSort(int[] arr) {
        // code here
        int n=arr.length;
        for(int i=0;i<=n-2;i++)
        {
            int min=i;
            for(int j=i;j<=n-1;j++)
            {
                if(arr[j]<arr[min])
                swap(arr,min,j);
            }
        }
    }
}
