import java.util.*;

public class BalancedString{
    public static void main(String args[]){
        String str = "LRRRRLLRLLRL";

        int counter = 0;
        int X = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'L'){
                counter++;
            }else{
                counter--;
            }

            if(counter == 0){
                X++;
            }
        }

        System.out.println("Maximum balanced substring : "+X);
    }
}