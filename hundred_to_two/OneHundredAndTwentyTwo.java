package TestOne.hundred_to_two;


public class OneHundredAndTwentyTwo {

    public static int maxProfit(int[] prices){
        if(prices == null || prices.length < 2){
            return 0;
        }
        int maxProfit = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{1,2,6,2,4,5}));
        System.out.println(maxProfit(new int[]{1,7,6,2,4,5}));
        System.out.println(maxProfit(new int[]{7,6,6,5,5}));
    }
}
