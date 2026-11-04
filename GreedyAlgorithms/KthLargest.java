import java.util.*;

public class KthLargest{

    public static int LargestOdd(int L, int R, int K){
        ArrayList<Integer> odds = new ArrayList<>();

        for(int i = L; i <= R; i++){
            if(i % 2 != 0){
                odds.add(i);
            }
        }

        if (K <= 0 || K > odds.size()) {
            return 0;
        }

        Collections.reverse(odds);
        return odds.get(K-1);
    }

    public static void main(String args[]){
        int L = 2, R = 4, K = 1;

        System.out.println("Kth largest odd number : "+LargestOdd(L,R,K));
    }
}