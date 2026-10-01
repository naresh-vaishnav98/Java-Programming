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


    public static void reverseArray(int arr[]){
        
        int start = 0;
        int end = arr.length-1;

        // System.out.print(arr[end]);
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void pairsInArray(int arr[]){

        for(int i = 0; i < arr.length; i++){
            int current = arr[i];
            for(int j = i+1; j < arr.length; j++){
                System.out.print("(" + current + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void subArray(int arr[]){
        int start = 0;
        int end = arr.length-1;

        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            for(int j = i+1; j < arr.length; j++){
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }


    public static void sumOfSubArray(int arr[]){
        int start = 0;
        int end = arr.length-1;

        int max_sum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            for(int j = i+1; j < arr.length; j++){
                for(int k = i; k <= j; k++){
                    sum += arr[k];
                    System.out.print(arr[k]+" ");
                }
                if(sum > max_sum){
                    max_sum = sum;
                }
                System.out.println("Sum is : "+sum);
                sum = 0;                
            }
        }

        System.out.println("Max sum is : " + max_sum);
    }

//Prefix Sum
    public static void prefixSubArray(int arr[]){

        int max_sum = Integer.MIN_VALUE;
        int sum = 0;

        int prefixArr[] = new int [arr.length];

        prefixArr[0] = arr[0];
        for(int i = 1; i < prefixArr.length; i++){
            prefixArr[i] = prefixArr[i-1] + arr[i];
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                sum = i == 0 ? prefixArr[j] : prefixArr[j] - prefixArr[i-1];

                if(sum > max_sum){
                    max_sum = sum;
                }
                System.out.println("Sum is : "+sum);
                sum = 0;                
            }
        }

        System.out.println("Max sum is : " + max_sum);
    }

// kadane's algorithm
    public static void kadaneSubArray(int arr[]){

        int max_sum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
                sum += arr[i];
                if(sum < 0){
                    sum = 0;
                }                

                if(sum > max_sum){
                    max_sum = sum;
                }
                System.out.println("Sum is : "+sum); 
        }

        System.out.println("Max sum is : " + max_sum);
    }

    public static void main(String args[]){
        // int num[] = {2,4,6,8,10,12,14};
        // int num[] = {1,-2,6,-1,3};
        int num[] = {-2,-3,4,-1,-2,1,5,-3};
        // int key = 5;
        // System.out.println(linearSearch(num,key));

        // System.out.println(Largest(num));

        // System.out.println(binarySearch(num,12));

        // reverseArray(num);

        // pairsInArray(num);

        // subArray(num);

        // sumOfSubArray(num);

        // prefixSubArray(num);

        kadaneSubArray(num);
    }
}