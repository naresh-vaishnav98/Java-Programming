import java.util.*;

public class LexicographicString{
    public static void main(String args[]){
        int N = 5, K = 42;
        StringBuilder str = new StringBuilder("");
        for(int i = 0; i < N; i++){
            str.append('a');
        }
        // System.out.println(str);
        K = K-N;
        

        for(int i = N-1; i >= 0; i--){
            if(K <= 0){
                break;
            }
            int min = Math.min(K,25);
            // str.charAt(i) = (char)(str.charAt(i) + min);
            char updatedChar = (char) (str.charAt(i) + min);
            str.setCharAt(i, updatedChar);
            K = K-min;
        }
        System.out.println(str.toString());
    }
}