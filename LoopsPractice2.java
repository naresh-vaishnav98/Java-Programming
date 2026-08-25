import java.util.*;

public class LoopsPractice2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Write a program that reads a set of integers,and then prints the sum of the even and odd integers.
        // System.out.println("Enter Set of Integers : ");
        // Long num =  sc.nextLong();
        // Long lastDig ;
        // int even = 0;
        // int odd = 0;

        // while (num > 0) {            
        //     lastDig = num%10;
        //     if(lastDig % 2 == 0){
        //         even += lastDig; 
        //     }else{
        //         odd += lastDig;
        //     }
        //     num /= 10;
        // }

        // System.out.println("Sum of Even numbers is : " + even);
        // System.out.println("Sum of Odd numbers is : " + odd);


        //Write a program to find the factorial of any number entered by the user.
        // System.out.println("Enter a Number : ");
        // int num = sc.nextInt();

        // int fact = 1;
        // for(int i = 1; i <= num; i++){
        //     fact *= i;
        // }
        // System.out.println("Factorial of "+num+" is : " + fact);


        //Write a program to print the multiplication table of a number N, entered by the user
        // System.out.println("Enter a Number : ");
        // int num = sc.nextInt();

        // for(int i = 1; i <= 10; i++){
        //     System.out.println(num + "x" + i + "=" + num*i);
        // }


        // Write a java program to check the given number is palindrome or not
        System.out.println("Enter a number : ");
        int x = sc.nextInt();
        int num = x;
        int lastDig = 0;
        int rev = 0;

        while(num > 0){
            lastDig = num % 10;
            rev = (rev * 10) + lastDig;
            num /=10;
        }
         if(rev == x){
            System.out.println("The Number is Palindrome !!");
         }else{
            System.out.println("The Number is Not Palindrome !!"); 
         }
    }
}
