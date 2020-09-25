public class cut_the_rope {

    public static void main(String[] args) {

        int ropeLength = 5;
        int maxProduct = dynamic(ropeLength);
        System.out.println("dynamic 最大乘积为：" + maxProduct);
        maxProduct = greedy(ropeLength);
        System.out.println("greedy 最大乘积为：" + maxProduct);
    }

    public static int dynamic(int ropeLength){

        if (ropeLength < 2)
            return 0;
        if (ropeLength == 2)
            return 1;
        if (ropeLength == 3)
            return 2;
        int[] products = new int[ropeLength + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= ropeLength; i++){
            max = 0;
            for (int j = 1; j <= i; j++){
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;
                products[i] = max;
            }
        }
        max = products[ropeLength];
        return max;
    }

    public static int greedy(int ropeLength){

        if (ropeLength < 2)
            return 0;
        if (ropeLength == 2)
            return 1;
        if (ropeLength == 3)
            return 2;
        int timesOf3 = ropeLength / 3;
        if ((ropeLength - timesOf3 * 3) == 1)
            timesOf3--;
        int timesOf2 = (ropeLength - timesOf3 * 3) / 2;
        int product = (3 ^ timesOf3) * (2 ^ timesOf2);
        return product;
    }
}
