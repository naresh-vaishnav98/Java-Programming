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

    public static void quickSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int pidx = pivotIndex(arr,si,ei);
        quickSort(arr,si,pidx-1);
        quickSort(arr,pidx+1,ei);
    }

    public static int pivotIndex(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
        for(int j = si; j < ei; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void stringMergeSort(String arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        stringMergeSort(arr,si,mid);
        stringMergeSort(arr,mid+1,ei);
        mergeStrings(arr,si,mid,ei);
    }

    public static void mergeStrings(String arr[], int si, int mid, int ei){
        int n1 = mid - si+1;
        int n2 = ei - mid;

        String leftArr[] = new String [n1];
        String rightArr[] = new String [n2];

        for(int i = 0; i < n1; i++){
            leftArr[i] = arr[si+i];
        }
        for(int j = 0; j < n2; j++){
            rightArr[j] = arr[mid+1+j];
        }

        int i = 0, j = 0;
        int k = si; 
        while(i < n1 && j < n2){
            if(leftArr[i].compareTo(rightArr[j]) < 0){
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

    public static int majorityElement(int nums[]){
        int count = 0;
        Integer curr = null;
        for(int num:nums){
            if(count == 0){
                curr = num;
            }
            count += (curr == num) ? 1 : -1;
        }
        return curr;
    }

    public static void main(String args[]){
        // int arr[] = {3,2,5,4,8,6};
        // mergeSort(arr,0,arr.length-1);
        // quickSort(arr,0,arr.length-1);

        // String arr[] = { "sun", "earth", "mars", "mercury" };
        // int ei = arr.length-1;
        // stringMergeSort(arr,0,ei);
        // for(int i = 0; i < arr.length; i++){
        //     System.out.print(arr[i]+" ");
        // }

        int arr[] = {2,2,1,1,1,2,2};
        System.out.print(majorityElement(arr));
    }
}