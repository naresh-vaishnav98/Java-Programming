import java.util.*;

public class OOPS{
    public static void main(String args[]){
        Complex c = new Complex();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Sum Of " + a +" and "+b+" is : " + c.sum(a,b));
        System.out.println("Differrence Of " + a +" and "+b+" is : " + c.diff(a,b));
        System.out.println("Product Of " + a +" and "+b+" is : " + c.prod(a,b));
    }
}

class Complex{
    int sum(int a, int b){
        return a+b;
    }

    int diff(int a, int b){
        return a-b;
    }

    int prod(int a, int b){
        return a*b;
    }
}