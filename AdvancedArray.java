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

    public static void main(String args[]){
        int height[] = {4,2,0,6,3,2,5};
        trappingRainwater(height,1);
    }
}