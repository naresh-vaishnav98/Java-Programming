import java.util.*;

public class Functions{

    public static int factorial(int a){
        int f = 1;
        for(int i = 1; i <= a; i++){
            f = f*i;
        }
        return f;
    }

    public static int bioCoeff(int n, int r){
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n-r);

        int n_c_r = fact_n/(fact_r*fact_nmr);
        return n_c_r;
    }

    public static boolean isPrime(int n){
        if(n == 2){
            return true;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
            return true;
    }

    public static void primeRange(int a){
        for(int i = 1; i <= a; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static int binToDec(int n){
        int pow = 0;
        int lastDig;
        int Dec = 0;

        while(n > 0){
            lastDig = n % 10;
            Dec = Dec + (lastDig * (int)Math.pow(2, pow));
            pow++;
            n /= 10;
        }
        return Dec;
    }

    public static int decToBin(int n){
        int pow = 0;
        int rem;
        int Bin = 0;

        while(n > 0){
            rem = n % 2;
            Bin = Bin + (rem * (int)Math.pow(10, pow));
            pow++;
            n /= 2;
        }
        return Bin;
    }

    public static void main(String args[]){
        System.out.println(binToDec(101));
        System.out.println(decToBin(5));
    }
}