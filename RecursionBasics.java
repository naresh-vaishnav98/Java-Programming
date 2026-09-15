public class RecursionBasics{

    public static void printDec(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }

    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n * fnm1;
        return fn;
    }

    public static void main(String args[]){
        // printDec(10);
        // printInc(8);
        System.out.print(fact(5));
    }
}