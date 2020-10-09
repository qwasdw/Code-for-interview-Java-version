public class one_plus_to_n {

    public static void main(String[] args) {

        System.out.println(sumToN(4));
    }

    public static int sumToN(int n){

        int sum = n;
        boolean b = n > 0 && (sum += sumToN(n - 1)) > 0;
        return sum;
    }
}
