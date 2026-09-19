import java.util.*;

public class DivideAndConquer{

    public static void mergeSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        int n1 = mid - si + 1;
        int n2 = ei - mid;

        int leftArr[] = new int [n1];
        int rightArr[] = new int [n2];

        for(int i = 0; i < n1; i++){
            leftArr[i] = arr[si+i];
        }
        for(int j = 0; j < n2; j++){
            rightArr[j] = arr[mid+1+j];
        }

        int i = 0;
        int j = 0;
        int k = si;

        while(i < n1 && j < n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String args[]){
        int arr[] = {3,2,5,4,8,6};
        mergeSort(arr,0,arr.length-1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}