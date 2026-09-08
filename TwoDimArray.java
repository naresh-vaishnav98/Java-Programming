import java.util.*;

public class TwoDimArray{

    public static void spiralMatrix(int arr[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = arr.length-1;
        int endCol = arr[0].length-1;

        while(startRow <= endRow && startCol <= endCol){
            for(int j = startCol; j <= endCol; j++){
                System.out.print(arr[startRow][j]+" ");
            }

            for(int i = startRow+1; i <= endRow; i++){
                System.out.print(arr[i][endCol]+" ");
            }

            for(int j = endCol-1; j >= startCol; j--){
                if(startRow == endRow){
                    break;
                }
                System.out.print(arr[endRow][j]+" ");
            }

            for(int i = endRow-1; i >= startRow+1; i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(arr[i][startCol]+" ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }


    public static int numCount(int arr[][],int key){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == key){
                    count++;
                }
            }
        }
        return count;
    }

    public static void sumOfRow(int arr[][], int row){
        int sum = 0;
        int rowNum = row-1;

        for(int i = 0; i < arr[rowNum].length; i++){
            sum += arr[rowNum][i];
        }
        System.out.print(sum);
    }

    public static void transposeMatrix(int arr[][]){
        int newArr[][] = new int [arr[0].length][arr.length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                newArr[j][i] = arr[i][j];
            }
        }

        for(int i = 0; i < newArr.length; i++){
            for(int j = 0; j < newArr[0].length; j++){
                System.out.print(newArr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void diagonalSum(int arr[][]){
        int sum = 0;
        int n = arr.length;
        int m = arr[0].length;
        // for(int i = 0; i < arr.length; i++){
        //     for(int j = 0; j < arr[0].length; j++){
        //         if(i == j){
        //             sum += arr[i][j];
        //         }else if((i+j) == (arr.length-1) && i != j){
        //             sum += arr[i][j];
        //         }
        //     }
        // }

        for(int i = 0; i < arr.length; i++){
            //Primary Diagonal
            sum += arr[i][i];
            //Secondary Diagonal
            if(i != arr.length-1-i){
                sum += arr[i][arr.length-1-i];
            }
            
        }
        System.out.print(sum);
    }

    public static boolean sortedMatrixSearch(int arr[][], int key){
        int row = 0;
        int col = arr[0].length-1;
        while(row < arr.length && col >= 0){
            if(key == arr[row][col]){
                System.out.print("Key found at : ("+ row +","+ col +")");
                return true;
            }else if(key < arr[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        // spiralMatrix(matrix);

        int nums[][] = { {1,4,9},{11,4,3},{2,2,3} };
        // System.out.print(numCount(nums,3));

        // sumOfRow(nums,2);
        // transposeMatrix(matrix);

        // diagonalSum(nums);

        sortedMatrixSearch(matrix,18);
    }
}