import java.util.*;


public class Pattern {
    public static void main(String[] args){
        // System.out.println("****");
        // System.out.println("***");
        // System.out.println("**");
        // System.out.println("*");


        Scanner sc = new Scanner(System.in);

        // Pyramid pattern
        // System.out.println("Enter a number of rows : ");
        // int rows = sc.nextInt();

        // for(int i = 1; i <= rows; i++){
        //     for (int j = 1; j <= rows - i; j++) {
        //     System.out.print(" ");
        // }
        // // Print stars
        // for (int k = 1; k <= 2 * i - 1; k++) {
        //     System.out.print("*");
        // }
        //     System.out.println("");
        // }

        // Hollow Rectangle pattern
        // System.out.println("Enter a number of rows : ");
        // int rows = sc.nextInt();

        // for(int i = 1; i <= rows; i++){
        //     for(int j = 1; j <= rows; j++){
        //         if (i == 1 || i == rows) {
        //             System.out.print("* ");
        //         }else{
        //             if (j == 1 || j == rows) {
        //                 System.out.print("* ");
        //             }else{
        //                 System.out.print("  ");
        //             }
        //         }
        //     }
        //     System.out.println();
        // }
        

        // INVERTED & ROTATED HALF-PYRAMID pattern
        System.out.println("Enter a number of rows : ");
        int rows = sc.nextInt();

        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= rows-i; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
