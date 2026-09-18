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

    public static int natralNumSum(int n){
        int sum = 0;
        if(n == 1){
            return 1;
        }
        int snm1 = natralNumSum(n-1);
        sum = n + snm1;
        return sum;
    }

    public static int fibonacciOfN(int n){
        if(n == 2 || n == 1){
            return 1;
        }else if(n == 0){
            return 0;
        }
        int fnm1 = fibonacciOfN(n-1);
        int fnm2 = fibonacciOfN(n-2);
        int fn = fnm1+fnm2;
        return fn;
    }

    public static boolean sortedArrayCheck(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return sortedArrayCheck(arr,i+1);
    }

    public static int firstOccurance(int arr[], int key, int i){
        if(i > arr.length-1){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        int ith = firstOccurance(arr,key,i+1);
        return ith;
    }

    public static int lastOccurance(int arr[], int key, int i){
        // i = arr.length-1;
        if(i < 0){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        int ith = lastOccurance(arr,key,i-1);
        return ith;
    }

    public static int xPowern(int x, int n){
        if(n == 0){
            return 1;
        }
        int xpnm1 = xPowern(x,n-1);
        int xpn = x*xpnm1;
        return xpn;
    }

    public static int tilingProblem(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        int fnm1 = tilingProblem(n-1);
        int fnm2 = tilingProblem(n-2);

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void removeDuplicates(String str, boolean map[], StringBuilder sb, int idx){
        if(idx == str.length()){
            System.out.print(sb);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true){
            removeDuplicates(str,map,sb,idx+1);
        }else{
            map[currChar-'a'] = true;
            removeDuplicates(str,map,sb.append(currChar),idx+1);
        }
    }

    public static int friendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }

        int fnm1 = friendsPairing(n-1);
        int fnm2 = friendsPairing(n-2);
        int pairWays = (n-1)*fnm2;

        int totWays = fnm1+pairWays;
        return totWays;
    }

    public static void binString(int n, int lastPlace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        binString(n-1,0,str+"0");
        if(lastPlace == 0){
            binString(n-1,1,str+"1");
        }        
    }

    public static void main(String args[]){
        // printDec(10);

        // printInc(8);

        // System.out.print(fact(5));

        // System.out.print(natralNumSum(5));

        // System.out.print(fibonacciOfN(6));

        // int arr[] = {1,5,6,4,6,5};
        // System.out.print(sortedArrayCheck(arr,0));

        // System.out.print(firstOccurance(arr,4,0));

        // System.out.print(lastOccurance(arr,5,arr.length-1));

        // System.out.print(xPowern(5,3));

        // System.out.print(tilingProblem(4));

        // String str = "nnaarreeessshhhh";
        // boolean map[] = new boolean [26];
        // StringBuilder sb = new StringBuilder();
        // removeDuplicates(str,map,sb,0);

        // System.out.print(friendsPairing(3));

        binString(4,0,"");
    }
}