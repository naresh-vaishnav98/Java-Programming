public class Sortings{

    public static void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    public static void bubbleSorting(int arr[]){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]){
        for(int i = 0; i < arr.length-1; i++){
            int smallest = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }

    public static void insertionSort(int arr[]){
        for(int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int j = i-1;
            while(j >= 0 && curr < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
    }

    public static void countSort(int arr[]){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int count[] = new int [max+1];
        for(int num : arr){
            count[num]++;
        }

        int index = 0;
        for(int i = 0; i <= max; i++){
            while(count[i]>0){
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }

    public static void main(String args[]){
        int arr[] = {3,6,2,1,8,7,4,5,3,1};
        // bubbleSorting(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        countSort(arr);
        printArray(arr);
    }
}