public class maximum_profit_of_the_stock {

    public static void main(String[] args) {

        int[] stockPrice = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxProfit(stockPrice));
    }

    public static int maxProfit(int[] stockPrice){

        if (stockPrice == null || stockPrice.length < 2)
            return 0;
        int minPrice = stockPrice[0];
        int result = stockPrice[1] - minPrice;
        for (int i = 2; i < stockPrice.length; i++){
            int diff = stockPrice[i] - minPrice;
            if (stockPrice[i] < minPrice)
                minPrice = stockPrice[i];
            if (result < diff)
                result = diff;
        }
        return result;
    }
}
