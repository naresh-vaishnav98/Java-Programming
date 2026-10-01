import java.util.*;

public class LoopsPractice {
    public static void main(String[] args){
        // Write a Java program that takes an integer N as input and prints the sum of all even numbers between 1 and N (inclusive) using a for-loop and an if-statement.
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a number : ");
        // int N = sc.nextInt();
        // int sum = 0;

        // for(int i=1; i<=N; i++){
        //     if(i % 2 == 0){
        //         sum = sum + i ;
        //     }
        // }

        // System.out.println("Sum of all EVEN numbers from 1 to " + N + " is : "+sum);






        //Write a program to print a 'Right Triangle' pattern of asterisks (*) with a height of N, where N is provided by the user.

        // System.out.println("Enter a Number : ");
        // int P = sc.nextInt();

        // for(int i=1; i<=P; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print("*");
        //     }
        //     System.out.print("\n");
        // }






        // Write a program that continues to ask the user for a password until they enter 'Java123'. Print 'Access Granted' upon success and 'Try Again' for incorrect attempts.

        while (true) {
            System.out.println("Enter Password : ");
            String pass = sc.nextLine();

            if (pass.equals( "Java123")) {
                System.out.println("Access Granted");
                break;
            }else{
                System.out.println("Try Again");
            }
            //Use .equals() to compare Java String values, not ==, Because in Java, == checks whether two variables point to the same String object in memory.
        }


    }
}
