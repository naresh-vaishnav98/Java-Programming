public class BuySellStock{
    public static void main(String args[]){
        int prices[] = {7, 1, 5, 3, 6, 4};
        int maxProfit = 0;

        // for(int i = 0; i < prices.length; i++){
        //     int curr = prices[i];
        //     int profit = 0;
        //     for(int j = i+1; j < prices.length; j++){
        //         if(prices[j] > prices[i]){
        //             profit = Math.max(profit, prices[j] - prices[i]);
        //         }
        //     }
        //     maxProfit = Math.max(maxProfit,profit);
        // }

        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit,profit);
            }
        }
        System.out.println("Maximum Profit : "+maxProfit);
    }
}