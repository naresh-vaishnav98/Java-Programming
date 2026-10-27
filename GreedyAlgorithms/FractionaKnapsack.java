import java.util.*;

public class FractionaKnapsack{
    public static void main(String args[]){
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        double ratio[][] = new double[value.length][2];

        for(int i = 0; i < value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = w;
        int finalValue = 0;
        for(int i = value.length-1; i >= 0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                capacity -= weight[idx];
                finalValue += value[idx];
            }else{
                finalValue += capacity * ratio[i][1];
                capacity = 0;
                break;
            }
        }

        System.out.println("Final Value : "+finalValue);
    }
}