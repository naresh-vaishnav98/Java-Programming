import java.util.*;

public class JavaInputs {
    public static void main(){

        Scanner sc = new Scanner (System.in);

        // Simple INPUTS using Scanner 

        // System.out.println("Enter your name: ");
        // String name = sc.nextLine();
        // System.out.println("Enter your age: ");
        // int age = sc.nextInt();
        // System.out.println("Enter any Float no.: ");
        // float price = sc.nextFloat();
        // System.out.println("Name: " + name);
        // System.out.println("Age: " + age);
        // System.out.println("Price : " + price);

        
        //Sum of 2 numbers
        
        // System.out.println("Enter value of a : ");
        // int a = sc.nextInt();
        // System.out.println("Enter value of b : ");
        // int b = sc.nextInt();
        // int sum = a+b;
        // System.out.println("Sum is : " + sum);

        
        // Produvt of two numbers

        // System.out.println("Enter value of a : ");
        // int a = sc.nextInt();
        // System.out.println("Enter value of b : ");
        // int b = sc.nextInt();
        // int product = a*b;
        // System.out.println("Producy of a and b is : " + product);


        // Area of Circle

        System.out.println("Enter Radius of Circle : ");
        float Radius = sc.nextFloat();

        double Area = 3.14 * Radius * Radius;

        System.out.println("Area of the Circle is : " + Area);

    }
}
