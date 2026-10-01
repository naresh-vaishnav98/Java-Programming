import java.util.*;

public class AdvancedArray{

    public static void trappingRainwater(int height[],int width){
        int leftArr[] = new int[height.length];
        int rightArr[] = new int[height.length];
        int totTrapWater = 0;


        for(int i = 0; i <= height.length-1; i++){
            if(i == 0){
                leftArr[i] = height[i];
            }else{
                if(height[i] < leftArr[i-1]){
                    leftArr[i] = leftArr[i-1];
                }else{
                    leftArr[i] = height[i];
                }
            }
        }
        
        // for(int i=0; i<leftArr.length; i++){
        //     System.out.print(leftArr[i]+ " ");
        // }

        for(int i = height.length-1; i >= 0; i--){
            if(i == height.length-1){
                rightArr[height.length-1] = height[height.length-1];
            }else{
                if(height[i] < rightArr[i+1]){
                    rightArr[i] = rightArr[i+1];
                }else{
                    rightArr[i] = height[i];
                }
            }
        }

        // for(int i=0; i<rightArr.length; i++){
        //     System.out.print(rightArr[i]+ " ");
        // }

        for(int i = 0; i < height.length; i++){
            int min = Math.min(rightArr[i],leftArr[i]);
            int trappedWater = (min - height[i])*width;
            totTrapWater += trappedWater;
        }
        System.out.println("Total Trapped Water is : "+ totTrapWater);
    }

    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    public static boolean repeatingNums(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] == curr){
                    return true;
                }
            }
        }
        return false;
    }

    public static int targetNum(int arr[], int key){
        int start = 0;
        int end = arr.length-1;                

        for(int i = start; i <= end; i++){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[start] <= arr[mid]){
                if(arr[start] <= key && key < arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(arr[mid] < key && key <= arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }


    public static int stockBuySell(int arr[]){
        int bp = 0;
        int sp = 0;
        int profit[] = new int [arr.length];
        int max_prof = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                bp = arr[i];
                sp = 0;
            }else{
                if(arr[i] > bp){
                    sp = arr[i];
                }else{
                    bp = arr[i];
                }
            }
            int prof = sp - bp;
            if(prof < 0){
                profit[i] = 0;
            }else{
                profit[i] = prof;
            }
            
        }

        for(int i = 0; i < profit.length; i++){
            // System.out.print(profit[i]+ " ");
            if(max_prof < profit[i]){
                max_prof = profit[i];
            }
        }
        return max_prof;
    }

    public static void main(String args[]){
        int height[] = {7, 1, 5, 3, 6, 4};
        // int height[] = {4,2,0,6,3,2,5};
        // int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        // trappingRainwater(height,1);
        // System.out.println(repeatingNums(height));

        // System.out.println(targetNum(height,0));

        System.out.println(stockBuySell(height));

    }
}