import java.util.*;


public class Arrays{

    public static void array(){
        int arr[] = new int[5];
        Scanner sc = new Scanner(System.in);

        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        
    }

    public static int linearSearch(int num[], int key){
        
        for(int i = 0; i < num.length; i++){
            if(num[i] == key){
                return i;
            }
        }
        return -1;
    }


    public static int Largest(int arr[]){
        
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
            if(arr[i] < smallest){
                smallest = arr[i];
            }
        }
        System.out.println(smallest);
        return largest;
    }

    public static int binarySearch(int num[], int key){
        int start = 0;
        int end = num.length-1;
        
        
        while(start <= end){        
            int mid = (start+end)/2;    
            if(num[mid] == key){
                return mid;
            }
            if(key > num[mid]){
                start = mid + 1;
            }
            if(key < num[mid]){
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        // array();
        int num[] = {2,4,6,8,10,12,14};
        // int key = 5;
        // System.out.println(linearSearch(num,key));
        // System.out.println(Largest(num));

        System.out.println(binarySearch(num,12));
    }
}