import java.util.*;

public class IndianCoins{
    public static void main(String args[]){
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int amt = 1059;
        Arrays.sort(coins, Collections.reverseOrder());
        
        
        int numOfCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amt){
                while(coins[i] <= amt){
                    ans.add(coins[i]);
                    numOfCoins++;
                    amt -= coins[i];
                }
            }
        }
        System.out.println("Number Of Coins : "+numOfCoins);
        System.out.println("Coins : "+ans);
    }
}