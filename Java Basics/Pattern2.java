import java.util.*;

public class Pattern2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();


        // Solid Rhombus
        // for(int i = 1; i <= rows; i++){
        //     for(int j = 1; j <= rows-i; j++){
        //         System.out.print(" ");
                
        //     }
        //     for(int j = 1; j <= rows; j++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }



        // Hollow Rhombus
        // for(int i = 1; i <= rows; i++){
        //     for(int j = 1; j <= rows-i; j++){
        //         System.out.print(" ");
                
        //     }
        //     for(int j = 1; j <= rows; j++){
        //         if(j == 1 || j == rows || i == 1 || i == rows){
        //             System.out.print("*");
        //         }else{
        //             System.out.print(" ");
        //         }
                
        //     }
        //     System.out.println();
        // }



        // Diamond pattern
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= rows-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= (2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = rows; i >= 1; i--){
            for(int j = 1; j <= rows-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= (2*i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}